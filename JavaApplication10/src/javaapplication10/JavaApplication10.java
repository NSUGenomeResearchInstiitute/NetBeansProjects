/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

/**
 *
 * @author User
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;


public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        File[] files = new File("C:\\Users\\User\\Desktop\\Arman nsu (Tracheal aspirate sample)Done").listFiles();
        BufferedReader bw;
        int i,j;
        try{
            String fileName = "MedicalReport.xls";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            HSSFWorkbook workbook = new HSSFWorkbook();
    //        for(File file : files){                
                HSSFSheet sheet = workbook.createSheet("1");
                int rowNum = 0;
                int colNum = 0;
               // if(file.isDirectory()){
                 //   File[] filelist = file.listFiles();
                    for(File filename : files){              
                       // j = 0;
                        if(filename.getName().endsWith(".txt")){                            
                            i = 0;
                            colNum = 0;
                           // System.out.println("i value: " + i);
//                            System.out.println("i vale: " + filename.getName());
                            Row row = sheet.createRow(rowNum++);
//                            Cell cell = row.createCell(colNum++);
                            bw = new BufferedReader(new FileReader(filename.getAbsoluteFile()));
                            while(i<25){
                                i++;
                                String str = bw.readLine();
//                                System.out.println("i vale: " + i);                                
//                                System.out.println("String: " + str);
                                if(i==2){                                    
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str);
                                   // System.out.println("Value: " + cell.getStringCellValue());
//                                    workbook.write(outputStream);                            
                                }else if(i == 3){
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str);
                                  //  System.out.println("Value: " + cell.getStringCellValue());
//                                    workbook.write(outputStream);                            
                                }else if(i == 6){
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str);
                                  //  System.out.println("Value: " + cell.getStringCellValue());
//                                    workbook.write(outputStream); 
                                }else if(i>12 && i< 25){
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str);
                                  //  System.out.println("Value: " + cell.getStringCellValue());
//                                    workbook.write(outputStream);                            
                                }
                            }
//                            workbook.write(outputStream);                            
                        }                        
                        
                        //j++;
                        //if(j==7)
                          //  break;
                    }
                //}try
                //break;
                workbook.write(outputStream);                            
                outputStream.close();
                workbook.close();
           // }for
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
