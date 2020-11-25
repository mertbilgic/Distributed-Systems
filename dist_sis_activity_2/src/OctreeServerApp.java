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
public class OctreeServerApp {

    public static void main(String[] args) {

        final int portNumber = 1900;
        try {
            Octree obj = new OctreeQuery();

            LocateRegistry.createRegistry(portNumber);

            Naming.rebind("rmi://localhost:1900"
                    + "/octree", obj);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
