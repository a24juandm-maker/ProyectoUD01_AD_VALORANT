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
            
            personaje.setId(son.get("uuid").toString());
            personaje.setName(son.get("displayName").toString());
            personaje.setDescription(son.get("description").toString());
            
            URI linkImage = new URI(son.get("displayIcon").getAsString());
            ImageIcon displayIcon = new ImageIcon(linkImage.toURL());
            personaje.setDisplayImagePj(displayIcon);
            
            System.out.println(son.get("abilities").toString());
            
            
            personajes.getListPj().add(personaje);
        }
        
        //initGUI();
    }
    
    public static void initGUI(){
        MainJFrame frame = new MainJFrame();
        FrontController fC = new FrontController(frame);
        frame.setVisible(true);
    }
}
