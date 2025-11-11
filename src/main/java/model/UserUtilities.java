/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christian
 */
public class UserUtilities {
    public static List<User> readUser(){
        List<User> listUsers = new ArrayList<>();
        
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("usuario.txt"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(UserUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listUsers;
    }
    
    public static void writeUser(List<User> listUsers){
        
        String fileUsers = "usuarios.txt" ;
        
        for(User user : listUsers){
        
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileUsers));
                bw.write(String.valueOf(user.getUsuario())+ ","+String.valueOf(user.getPassword()));
                
            } catch (IOException ex) {
                Logger.getLogger(UserUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }
}
