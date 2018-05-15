/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author User
 */

import org.jpedal.examples.text.ExtractTextInRectangle;

public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ExtractTextInRectangle extract = new ExtractTextInRectangle("1.pdf", true);
         try{
            if (extract.openPDFFile()) {
                int pageCount=extract.getPageCount();
                for (int page=1; page<=pageCount; page++) {
                    System.out.println(extract.getTextOnPage(page));
                }
            } 
         }catch(Exception ex){
             ex.printStackTrace();
         }            
    }
    
}
