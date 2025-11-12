/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import controller.FrontController;
import java.io.IOException;
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
import view.MainJFrame;

/**
 *
 * @author dam2_alu13@inf.ald
 */
public class APIValorant {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://valorant-api.com/v1/agents")).build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonArray arrayRaiz = json.getAsJsonArray("data");
        
        List<Pj> listaPersonajes = new ArrayList<>();
        Pjs personajes = new Pjs(listaPersonajes);
        for(JsonElement element : arrayRaiz){
            Pj personaje = new Pj();
            JsonObject son = element.getAsJsonObject();
            
            personaje.setId(son.get("uuid").getAsString());
            personaje.setName(son.get("displayName").getAsString());
            personaje.setDescription(son.get("description").getAsString());
            
            URI linkImage = new URI(son.get("displayIcon").getAsString());
            ImageIcon displayIcon = new ImageIcon(linkImage.toURL());
            personaje.setDisplayImagePj(displayIcon);
            
            JsonArray arrayAbilities = son.getAsJsonArray("abilities");
            List<Hability> listaHabilidades = new ArrayList<>();
            for(JsonElement habilidad : arrayAbilities){
                JsonObject habilidadSon = habilidad.getAsJsonObject();
                
                String nombreHabilidad = habilidadSon.get("displayName").getAsString();
                String descripcion = habilidadSon.get("description").getAsString();
                
                ImageIcon displayIconHability = null;
                URI displayIconUri;
                try{
                    JsonElement displayIconLink = habilidadSon.get("displayIcon");
                    displayIconUri = new URI(displayIconLink.getAsString());
                    displayIconHability = new ImageIcon(displayIconUri.toURL());
                }catch(Exception e){
                    displayIconUri = new URI("https://static.wikia.nocookie.net/xtaleunderverse4071/images/8/8a/Fatal_Error_Underverse.jpg");
                }
                System.out.println(displayIconUri);
                Hability habilidadPJ = new Hability(nombreHabilidad, descripcion, "", displayIconHability);
                listaHabilidades.add(habilidadPJ);
            }
            personaje.setHability(listaHabilidades);
            
            personajes.getListPj().add(personaje);
        }
        
        for(Pj personaPj : listaPersonajes){
            
        }
        
        initGUI(listaPersonajes);
    }
    
    public static void initGUI(List<Pj> listaPersonajes){
        ImageIcon image = listaPersonajes.get(0).getHability().get(1).getDisplayImageHability();
        
        JFrame frame = new JFrame();
        frame.setBounds(400, 400, 400, 400);
        
        JLabel label =  new JLabel();
        label.setIcon(image);
        label.setBounds(5,5,5,5);
        frame.add(label);
        frame.setVisible(true);
    }
}
