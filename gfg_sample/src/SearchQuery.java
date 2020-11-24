/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author mertbilgic
 */
public class SearchQuery extends UnicastRemoteObject
        implements Search {

    public SearchQuery() throws RemoteException {
        super();
    }

    @Override
    public String query(String search) throws RemoteException {
        String result;
        if (search.equals("Reflection in Java")) {
            result = "Found";
        } else {
            result = "Not Found";
        }

        return result;
    }

}
