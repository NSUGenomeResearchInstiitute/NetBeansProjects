/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author User
 */

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File[] files = new File("C:\\Users\\User\\Desktop\\arman pdf samples").listFiles();
        PDDocument document;
        PDFTextStripper stripper;
        BufferedWriter bw;
        
        for(File file : files){
            if(file.isDirectory()){
                File[] filelist = file.listFiles();
                for(File filename : filelist){
                    try{
                        String filen = filename.getName();
                        String[] filenm = filen.split(".pdf");
                        System.out.println("length: " + filenm.length);
                        System.out.println("File name of the filelist: " + filenm[0]);
                        filenm[0] += ".txt";
                        System.out.println("Out file name: " + filenm[0]);
                        File filenme = filename.getAbsoluteFile();
                        String path = filename.getAbsolutePath();
                        System.out.println("Path: " + path);                        
                        document = PDDocument.load(filenme);
                        stripper = new PDFTextStripper();
                        String text = stripper.getText(document);
                        bw = new BufferedWriter(new FileWriter(filename.getCanonicalPath() + filenm[0]));          
                        bw.write(text);
                        bw.flush();
                        bw.close();
                        break;
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }                                     
                }
            }
            break;
        }
    }
    
}
