/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.image.BufferedImage;
import java.rmi.*;
/**
 *
 * @author mertbilgic
 */
public interface Octree extends Remote{
    
    public void query(String imgPath,String title) 
            throws RemoteException;
}
