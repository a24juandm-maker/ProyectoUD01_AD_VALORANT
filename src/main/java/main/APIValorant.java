/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import controller.FrontController;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Hability;
import model.Pj;
import model.Pjs;
import model.User;
import model.UserUtilities;
import model.Users;
import view.MainJFrame;

/**
 *
 * @author dam2_alu13@inf.ald
 */
public class APIValorant {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException{
              
        
        MainJFrame view = new MainJFrame();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        List<Pj> listaPersonajes = new ArrayList<>();
        Pjs dataPersonajes = new Pjs();
        dataPersonajes.setListPj(listaPersonajes);
        List<User> users = UserUtilities.readUser();
        if(users == null){
            users = new ArrayList<>();
        }

        Users dataUsuario = new Users();
        dataUsuario.setListUsers(users);
        
        JsonArray arrayRaiz = connectionWithApi();
        recoveryDataApi(arrayRaiz, dataPersonajes);
        FrontController fc = new FrontController(view,dataPersonajes,dataUsuario);
        
        view.setVisible(true);
        //initGUI(listaPersonajes);
        //UserUtilities.writePjsUserJSON("usuario", listaPersonajes);
        
        
    }

    private static void recoveryDataApi(JsonArray arrayRaiz, Pjs personajes) throws URISyntaxException, MalformedURLException {
        for(JsonElement element : arrayRaiz){
            Pj personaje = new Pj();
            JsonObject son = element.getAsJsonObject();
            
            personaje.setId(son.get("uuid").getAsString());
            personaje.setName(son.get("displayName").getAsString());
            personaje.setDescription(son.get("description").getAsString());
            // Modo Prueba
            JsonObject objectRole = son.get("role").getAsJsonObject();
            personajes.addRole(objectRole.get("displayName").getAsString());
            personaje.setRole(objectRole.get("displayName").getAsString());
            personaje.setDisplayImagePj(son.get("displayIcon").getAsString());
            personaje.setGreatPjImage(son.get("fullPortrait").getAsString());
            
            
            JsonArray arrayAbilities = son.getAsJsonArray("abilities");
            List<Hability> listaHabilidades = new ArrayList<>();
            for(JsonElement habilidad : arrayAbilities){
                JsonObject habilidadSon = habilidad.getAsJsonObject();
                
                String nombreHabilidad = habilidadSon.get("displayName").getAsString();
                String descripcion = habilidadSon.get("description").getAsString();
                String displayIconHability = "";
                try {
                    displayIconHability = habilidadSon.get("displayIcon").getAsString();
                } catch(UnsupportedOperationException ex){
                    displayIconHability = "";
                }
                
                
                Hability habilidadPJ = new Hability(nombreHabilidad, descripcion, displayIconHability);
                                
                listaHabilidades.add(habilidadPJ);
            }
            personaje.setHability(listaHabilidades);
            
            personajes.getListPj().add(personaje);
        }
    }

    private static JsonArray connectionWithApi() throws IOException, InterruptedException, JsonSyntaxException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://valorant-api.com/v1/agents")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonArray arrayRaiz = json.getAsJsonArray("data");
        return arrayRaiz;
    }
    
    public static void initGUI(List<Pj> listaPersonajes) {
        try {
            //ImageIcon image = listaPersonajes.get(0).getHability().get(1).getDisplayImageHability();
            URI linkImage = new URI(listaPersonajes.get(0).getGreatPjImage());
            ImageIcon image = new ImageIcon(linkImage.toURL());
            
            JFrame frame = new JFrame();
            frame.setBounds(400, 400, 400, 400);
            
            JLabel label =  new JLabel();
            label.setIcon(image);
            label.setBounds(5,5,5,5);
            frame.add(label);
            frame.setVisible(true);
        } catch (URISyntaxException | MalformedURLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
