/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.*;
import javax.imageio.ImageIO;

/**
 *
 * @author mertbilgic
 */
public class ClientRequest {

    public static void main(String[] args) {
        String imagePath = "image/test1.jpeg";
        BufferedImage img = ImageOperations.readImage(imagePath);
        ImageOperations.showImage(img, "Orginal");
        // Simülasyon için beliritilen algoritmalar yerine filtreleme algoritması kullanılmıştır.
        try {
            long t1 = System.currentTimeMillis();
            Octree access
                    = (Octree) Naming.lookup("rmi://localhost:1900"
                            + "/octree");
            access.query(imagePath, "Octree");
            long t2 = System.currentTimeMillis();
            long duration = t2 - t1;
            System.out.println("Octree operation takes: " + duration + " ms");

            t1 = System.currentTimeMillis();
            Median request
                    = (Median) Naming.lookup("rmi://localhost:1901"
                            + "/median");
            request.query(imagePath, "Median");
            t2 = System.currentTimeMillis();
            duration = t2 - t1;
            System.out.println("Median operation takes: " + duration + " ms");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
