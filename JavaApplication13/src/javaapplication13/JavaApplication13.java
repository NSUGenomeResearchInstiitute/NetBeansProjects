/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author User
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String a = "This is";
        String b = "test";
        String c = new String();
        c = c.concat(a);
        System.out.println("C: " + c);
        c = c.concat(b);
        System.out.println("New C: " + c);
    }
    
}
