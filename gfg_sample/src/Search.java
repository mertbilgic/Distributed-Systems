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
public interface Search extends Remote{
    
    public String query(String search) 
            throws RemoteException;
}
