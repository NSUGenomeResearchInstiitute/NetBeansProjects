/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

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

public class JavaApplication19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File[] files = new File("C:\\Users\\User\\Desktop\\arman pdf samples").listFiles();
        BufferedReader bw;
        int i;
        
        try{
            String fileName = "MedicalReport.xls";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            HSSFWorkbook workbook = new HSSFWorkbook();
            for(File file : files){                
                HSSFSheet sheet = workbook.createSheet(file.getName());
                int rowNum = 0;
                int colNum = 0;
                if(file.isDirectory()){
                    File[] filelist = file.listFiles();                                  
                    for(File filename : filelist){                         
                        if(filename.getName().endsWith(".txt")){                             
                            i = 0;
                            colNum = 0;
                            Row row = sheet.createRow(rowNum++);
                            Cell celll = row.createCell(colNum++);
                            celll.setCellValue((String)filename.getName());
                            bw = new BufferedReader(new FileReader(filename.getAbsoluteFile()));
                            while(i<24){
                                i++;
                                String str = bw.readLine();
                                if(i==2){        //invoice                            
                                    String[] stri = str.split(" ");
                                    Cell cell;
                                    cell = row.createCell(colNum++);
                                    cell.setCellValue((String)stri[3]);
                                    cell = row.createCell(colNum++);
                                    cell.setCellValue((String)stri[7]);
                                    cell = row.createCell(colNum++);
                                    cell.setCellValue((String)stri[11]);                          
                                }else if(i == 3){  //patient
                                    String[] stri = str.split(" ");
                                    String pname = new String();                                    
                                    int j;
                                    for(j = 3 ; j<stri.length; j++){
                                        if(stri[j].equalsIgnoreCase("Age")){
                                            break;
                                        }
                                        //System.out.println("string: " + stri[j]);
                                        pname += " ";
                                        pname = pname.concat(stri[j]);
                                        //System.out.println("Patient: " + pname);
                                    }
                                    Cell cell;
                                    cell = row.createCell(colNum++);
                                    cell.setCellValue((String)pname);
                                    cell = row.createCell(colNum++);
                                    String Age  = new String();                                    
                                    for( j += 2 ; j<stri.length; j++){
                                        if(stri[j].equalsIgnoreCase("Gender")){
                                            break;
                                        }
                                        //System.out.println("string: " + stri[j]);                                        
                                        Age = Age.concat(stri[j]);
                                        Age += " ";
                                        //System.out.println("Patient: " + pname);
                                    }
                                    cell.setCellValue((String)Age);                                      
                                    cell = row.createCell(colNum++);
                                    cell.setCellValue((String)stri[stri.length-1]); 
                                }else if(i == 6){   //a
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str);
                                }else if(i == 8){    //b
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str); 
                                }else if(i>12 && i< 25 && str != null){ //list i 18 23 24
                                    String[] stri = str.split(" ");                                    
                                    int j = 0;
                                    String sname = new String();
                                    //System.out.println("String: " + str);
                                    for( ; j<stri.length ; ){
                                        if(stri[j].length()==1){
                                            sname = new String();
                                            if(stri[j-1].equalsIgnoreCase("Acid")){
                                                sname = sname.concat(stri[j-2]); 
                                                sname = sname.concat(" ");
                                            }
                                            sname = sname.concat(stri[j-1]);
                                            sname = sname.concat(" ");
                                            sname = sname.concat(stri[j]);
                                            sname = sname.concat(" ");
                                            if((j+1<stri.length) && stri[j+1].length()==1){
                                                sname = sname.concat(stri[j+1]);
                                                sname = sname.concat(" ");
                                                j+=1;
                                            }
                                            Cell cell = row.createCell(colNum++);
                                            cell.setCellValue((String)sname); 
                                        }else if(j+1<stri.length && stri[j+1].equalsIgnoreCase("Acid")){
                                            sname = new String();
                                            sname = sname.concat(stri[j]);
                                            sname = sname.concat(" ");
                                            sname = sname.concat(stri[j+1]);
                                            j+=1;
//                                            Cell cell = row.createCell(colNum++);
//                                            cell.setCellValue((String)sname); 
                                        }                 
                                        j+=1;
                                    }                                    
                                }
                            }                         
                        } 
                    }
                }
            }
            workbook.write(outputStream);                            
            outputStream.close();
            workbook.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
