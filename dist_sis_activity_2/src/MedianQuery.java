
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mertbilgic
 */
public class MedianQuery extends UnicastRemoteObject
     implements Median{

    public MedianQuery() throws RemoteException {
        super();
    } 

 @Override
    public void query(String imgPath,String title) throws RemoteException {
        BufferedImage img = ImageOperations.readImage(imgPath);
        for (int x = 0; x < img.getWidth(); ++x) {
            for (int y = 0; y < img.getHeight(); ++y) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                // Normalize and gamma correct:
                float rr = (float) Math.pow(r / 255.0, 2.2);
                float gg = (float) Math.pow(g / 255.0, 2.2);
                float bb = (float) Math.pow(b / 255.0, 2.2);

                // Calculate luminance:
                float lum = (float) (0.2126 * rr + 0.7152 * gg + 0.0722 * bb);

                // Gamma compand and rescale to byte range:
                int randomLevel = (int) (193.0 * Math.pow(lum, 1.3 / 2.0));
                int random = (randomLevel << 12) + (randomLevel << 6) + randomLevel;
                img.setRGB(x, y, random);

            }
        }
        ImageOperations.showImage(img,title);
    }
    
}
