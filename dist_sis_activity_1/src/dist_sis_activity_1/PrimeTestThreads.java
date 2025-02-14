package dist_sis_activity_1;



public class PrimeTestThreads extends Thread {

    int index;
    PrimeTestParallel atasad ;
    public PrimeTestThreads(int index) {
        this.index = index;
    }

    public void run() {
        startTimes[index] = System.currentTimeMillis();
        PrimeTestParallel.isPrime(numbers[index]);
        endTimes[index] = System.currentTimeMillis();
    }

    /**
     * only test odd divisors. even numbers can not be primes start with 3 and
     * test with every odd number: 3, 5, 7, 9, go up to the square root of the
     * tested number the numbers larger than the square root can not divide be
     * sole divisors
     */
    public static boolean isPrime(long x) {
        if (x % 2 == 0) {
            return false;
        }
        long p = 3;
        long xsqrt = (long) Math.ceil(Math.sqrt(x));
        while (p <= xsqrt) {
            if (x % p == 0) {
                return false;
            }
            p += 2;
        }
        return true;
    }
    static long start;
    static long startTimes[];
    static long endTimes[];
    //static long numbers[] = {1000000000000037L, 1000000000000091L};
    static long numbers[] = {1000000000000037L, 1000000000000091L,1000000000000159L, 1000000000000187L};

    public static void main(String[] args) throws Exception {
        start = System.currentTimeMillis();
        startTimes = new long[numbers.length];
        endTimes = new long[numbers.length];
        PrimeTestThreads threadler[] = new PrimeTestThreads[numbers.length];
        for (int i = 0; i < threadler.length; i++) {
            threadler[i] = new PrimeTestThreads(i);
        }
        for (int i = 0; i < threadler.length; i++) {
            threadler[i].start();
        }
// wait until all threads are done
        boolean notDone = true;
        while (notDone) {
            notDone = false;
            for (int i = 0; i < threadler.length; i++) {
                if (threadler[i].isAlive()) {
                    notDone = true;
                }
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + " start: " + (startTimes[i] - start));
            System.out.println(i + " end: " + (endTimes[i] - start));
        }
    }
}
