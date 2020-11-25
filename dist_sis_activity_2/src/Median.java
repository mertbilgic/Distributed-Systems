
import java.rmi.RemoteException;
import java.rmi.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mertbilgic
 */
public interface Median extends Remote {

    public void query(String imgPath, String title)
            throws RemoteException;
}
