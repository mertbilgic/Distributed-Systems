/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.rmi.registry.*;

/**
 *
 * @author mertbilgic
 */
public class MedianServerApp {

    public static void main(String[] args) {

        final int portNumber = 1901;
        try {
            Median obj = new MedianQuery();

            LocateRegistry.createRegistry(portNumber);

            Naming.rebind("rmi://localhost:1901"
                    + "/median", obj);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
