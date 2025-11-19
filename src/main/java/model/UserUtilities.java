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

    public static void guardarPjsUsuario(String nombreUsuario, List<Pj> listaPjs) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || listaPjs == null) {
            return;
        }

        Gson gson = new Gson();
        String archivo = nombreUsuario.trim() + ".json";

        // Convertir Pj → PjData (solo datos, sin JButton)
        List<PjData> datos = new ArrayList<>();
        for (Pj pj : listaPjs) {
            datos.add(new PjData(pj));
        }

        PjsData contenedor = new PjsData();
        contenedor.setListPj(datos);

        FileWriter writer = null;
        try {
            writer = new FileWriter(archivo);
            gson.toJson(contenedor, writer);
            System.out.println("Guardado correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("ERROR GUARDADO: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error cerrando writer: " + e.getMessage());
                }
            }
        }
    }

    public static List<Pj> cargarPjsUsuario(String nombreUsuario) {
        Gson gson = new Gson();
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
            return null;
        }

        String archivo = nombreUsuario.trim() + ".json";
        File file = new File(archivo);
        if (!file.exists()) {
            return null;
        }

        FileReader reader = null;
        try {
            reader = new FileReader(file);
            PjsData contenedor = gson.fromJson(reader, PjsData.class);

            if (contenedor == null || contenedor.getListPj() == null || contenedor.getListPj().isEmpty()) {
                return null;
            }

            // Convertir PjData → Pj
            List<Pj> lista = new ArrayList<>();
            for (PjData data : contenedor.getListPj()) {
                lista.add(data.toPj());
            }

            return lista;

        } catch (Exception e) {
            System.err.println("Error al cargar " + archivo + ": " + e.getMessage());
            e.printStackTrace();
            return null;
        } 
    }
}
