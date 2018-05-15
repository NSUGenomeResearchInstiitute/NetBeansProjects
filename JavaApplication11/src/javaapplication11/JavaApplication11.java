/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

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


public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        File[] files = new File("C:\\Users\\User\\Desktop\\arman pdf samples").listFiles();
        BufferedReader bw;
        int i,count;
        String[] Data = {"Id","Invoice No", "Invoice Date", "Delivery Date", 
                        "Patient Name" , "Age", "Gender",
                        "Organism Isolated" , "Organism Isolated", 
                         "Amikacin", "Ciprofloxacin", "Netilmicin",
                        "Amoxycillin", "Colistin", "Nitrofurantoin",
                        "Amoxyclave", "Co-trimoxazole", "Penicillin",
                        "Azithromycin", "Doxycycline", "Piperacillin/Tazobactum",
                        "Aztreonam", "Erythromycin", "Polymyxin B",
                        "Cefepime", "Gentamicin", "Tetracycline",
                        "Cefixime", "Imipenem", "Vancomycin",
                        "Cefotaxime", "Levofloxacin", "Ampicillin",
                        "Ceftazidime", "Linezolid", "Tigecycline",
                        "Ceftriaxone", "Mecillinam", "Fusidic acid",
                        "Cefuroxime", "Meropenem", "Oxacillin",
                        "Chloramphenicol", "Nalidixic Acid", "Teicoplanin"};
        
        try{
            String fileName = "MedicalReport.xls";
            FileOutputStream outputStream = new FileOutputStream(fileName);
            HSSFWorkbook workbook = new HSSFWorkbook();
            for(File file : files){                
                HSSFSheet sheet = workbook.createSheet(file.getName());
                int rowNum = 0;
                int colNum = 0;
                if(file.isDirectory()){
                    for(String data : Data){
                        Row row = sheet.createRow(rowNum++);
                        Cell cell = row.createCell(colNum++);
                        cell.setCellValue((String)data);
                    }
                    File[] filelist = file.listFiles();                    
                    for(File filename : filelist){ 
                        count = 1;
                        if(filename.getName().endsWith(".txt")){                            
                            i = 0;
                            colNum = 0;
                            Row row = sheet.createRow(rowNum++);
                            Cell celll = row.createCell(colNum++);
                            celll.setCellValue((Integer)count);
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
                                        pname.concat(stri[j]);
                                    }
                                    Cell cell;
                                    cell = row.createCell(colNum++);
                                    cell.setCellValue((String)pname);
                                    cell = row.createCell(colNum++);
                                    cell.setCellValue((String)stri[j+1]);                            
                                }else if(i == 6){   //a
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str);
                                }else if(i == 8){    //b
                                    Cell cell = row.createCell(colNum++);
                                    cell.setCellValue((String)str); 
                                }else if(i>12 && i< 25){ //list
                                    String[] stri = str.split(" ");
                                    Cell cell;
                                    System.out.println("String length: " + stri.length);
                                    if(stri.length>3 && stri.length <= 7){
                                        if(stri.length == 4){
                                            if(stri[1] != null || stri[3] != null || stri[1].equalsIgnoreCase("R")||stri[1].equalsIgnoreCase("S")||stri[1].equalsIgnoreCase("I") ||stri[3].equalsIgnoreCase("R")||stri[3].equalsIgnoreCase("S")||stri[3].equalsIgnoreCase("I"))
                                                if(stri[1] != null){
                                                    cell = row.createCell(colNum++);
                                                    cell.setCellValue(stri[1]);
                                                }
                                            if(stri[3] != null){
                                                    cell = row.createCell(colNum++);
                                                    cell.setCellValue(stri[3]);
                                            }
                                        }
                                        cell = row.createCell(colNum++);
                                        if(stri[1].equalsIgnoreCase("R")||stri[1].equalsIgnoreCase("S")||stri[1].equalsIgnoreCase("I")){
                                            cell.setCellValue((String)stri[1]);
                                        }                                        
                                        cell = row.createCell(colNum++);
                                        if(stri[3].equalsIgnoreCase("R")||stri[3].equalsIgnoreCase("S")||stri[3].equalsIgnoreCase("I")){
                                            cell.setCellValue((String)stri[3]);
                                        }
                                        if(stri[5] != null && (stri[5].equalsIgnoreCase("B") || stri[5].equalsIgnoreCase("Acid")) ){
                                            cell = row.createCell(colNum++);
                                            if(stri[6] !=null){
                                                cell.setCellValue((String)stri[6]);
                                            }                                            
                                        }else if(stri[3].equalsIgnoreCase("Acid")){
                                            cell = row.createCell(colNum++);
                                            if(stri[6] != null){
                                                cell.setCellValue((String)stri[4]);
                                            }                                            
                                        }                                         
                                    }else{
                                        colNum += 3;
                                    }
                                                             
                                }
                            }                         
                        } 
                        count++;
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
