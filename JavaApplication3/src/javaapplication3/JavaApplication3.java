/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author User
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.Raster;

public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            BufferedImage image = ImageIO.read(new File("1.jpg"));
            Raster rs = image.getData();
            System.out.println("Height and width : " + rs.getHeight()+ "   "  + rs.getWidth());
            System.out.println("Data: " + rs.toString());
            System.out.println(rs.getNumDataElements());
            Object o;
            o = new Object();
            int height = image.getHeight();
//            for (int i = 0; i<rs.getNumDataElements(); i++){
//                System.out.println(rs.getDataElements(0, 400, o));
//            }
        }catch(IOException exception){
            exception.printStackTrace();
        }
        
    }
    
}
