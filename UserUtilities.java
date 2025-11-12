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
import java.io.Serializable;
import java.io.*;

/**
 *
 * @author christian
 */
public class UserUtilities implements Serializable {

    private static String fileSaveUsers = "usuarios.user";
    public static List<User> readUser() {
        
        List<User> listUsers = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileSaveUsers));
            listUsers = (List<User>) ois.readObject();
            
        } catch (IOException ex) {
            System.out.println("Fallo lectura fichero" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("No encuentra la clase en ReadUser" + ex.getMessage());
        }
        
        return listUsers;
    }

    public static void writeUser(List<User> listUsers) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileSaveUsers));
            out.writeObject(listUsers);
            out.close();

        } catch (IOException ex) {
            System.out.println("Fallo escritura fichero" + ex.getMessage());
        }

    }
}
