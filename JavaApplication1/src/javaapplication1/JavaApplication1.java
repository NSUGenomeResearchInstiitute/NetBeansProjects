/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author User
 */

import java.io.BufferedReader;
import java.io.Reader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.PDFReader;
import org.apache.pdfbox.TextToPDF;

import java.nio.file.*;

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            BufferedReader in
                 = new BufferedReader(new FileReader("1.pdf"));
            //for(int i  = 0; i<50; i++){
              //  String str = in.readLine();
                //System.out.println(str);
            //}            
        }catch(IOException exception){
            exception.printStackTrace();
        }
        try{
            File file = new File("8.pdf");
            PDDocument document = PDDocument.load(file);
            //document.save("Out1.pdf");
            
//            RandomAccessBufferedFileInputStream bf = new RandomAccessBufferedFileInputStream(file);
//            PDMetadata meta = new PDMetadata(document);
//            InputStream inf = meta.createInputStream();
//            System.out.println(inf.read());
//            while(bf.available()>0){
//                System.out.println(bf.read());
//            }
//            COSDocument doc = new COSDocument(file);
//            COSDocument doc1 = document.getDocument();
            
//            PDFParser ps = new PDFParser(new FileInputStream(file));
//            ps.parse();
            
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
            //stripper.extractRegions(new PDPage());
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            BufferedWriter bw = new BufferedWriter(new FileWriter("out8.txt"));          
            bw.write(text);
            bw.flush();
            bw.close();
//            System.out.println(text);
//            pdfStripper.writeText(document, bw);
//            TextToPDF doc = new TextToPDF();
//            PDDocument docum = doc.createPDFFromText(new Reader(text));
            
//            PDFReader reader = new PDFReader(new File("1.pdf"));
//            reader.open(); // open the file. 
//            int pages = reader.getNumberOfPages();
// 
//            for(int i=0; i < pages; i++) {
//                String text = reader.extractTextFromPage(i);
//                System.out.println("Page " + i + ": " + text); 
//            }
 
  // perform other operations on pages.
//              reader.close();
            //PDDocument document1 = PDDocument.load(new File("Out.pdf"));
            //String text = pdfStripper.getText(document1);
            //String lines[] = text.split("\n");
            //PDFTextStripper pdfStripper = new PDFTextStripper("1.pdf");
            //String str = pdfStripper.getLineSeparator();
            //System.out.println(text);
            //for(String line:lines){
              //  System.out.println(line);
            //}
            //System.out.println(doc.getHeaderString());
            //System.out.println(text);
            document.close();
        }catch(Exception exceptio){
            exceptio.printStackTrace();
        }
        //PDFReader pdf = new PDFReader("1.pdf");
        //System.out.println(pdf.getParsedText())
    }
    
}
