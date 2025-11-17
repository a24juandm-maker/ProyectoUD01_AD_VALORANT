/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    
    public static void writePjsUserJSON(String nombreUsuario, List<Pj> listaPjsEntrada) throws FileNotFoundException, IOException{
        
        File rutaArchivos = new File(".");
        File[] listaArchivos = rutaArchivos.listFiles();
        String ficheroJSONUsuario = nombreUsuario+".json";
        for(File f : listaArchivos){
            Gson gson = new Gson();
            Pjs listaPjsFicheros;
            if(f.isFile() && f.toString().equals(nombreUsuario +".json")){
                
                BufferedReader lecturaFichero = new BufferedReader(new FileReader(f));
                
                listaPjsFicheros = gson.fromJson(lecturaFichero, Pjs.class);
                
                if(listaPjsFicheros != listaPjsEntrada){
                    

                    //String listaJsonPjs = gson.toJson(listaPjsFicheros);
                    
                    BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroJSONUsuario));
                    bw.write(gson.toJson(listaPjsFicheros));
                    bw.flush();
                    bw.close();
                }
                else{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroJSONUsuario));
                    //String listaEntrada = gson.toJson(listaPjsEntrada);
                    bw.write(gson.toJson(listaPjsEntrada));
                    bw.flush();
                    bw.close();
                }
                
                
                
            }
            else{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroJSONUsuario));

                    bw.write(gson.toJson(listaPjsEntrada));
                    bw.flush();
                    bw.close();
                }
        }
    
    }
}
