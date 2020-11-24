/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;

/**
 *
 * @author mertbilgic
 */
public class ClientRequest {

    public static void main(String[] args) {
        String answer, value = "Reflection in Java";
        try {
            Search access
                    = (Search) Naming.lookup("rmi://localhost:1900"
                            + "/geeksforgeeks");
            answer = access.query(value);
            System.out.println("Article on " + value
                    + " " + answer + " at GeeksforGeeks");

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
