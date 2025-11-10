/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appvalorant;

import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 *
 * @author dam2_alu02@inf.ald
 */
public class AppValorant {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://valorant-api.com/v1/agents")).build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonArray arrayRaiz = json.getAsJsonArray("data");
        
        for(JsonElement element : arrayRaiz){
            JsonObject son = element.getAsJsonObject();
            System.out.println(son.get("uuid"));
        }
        
    }
}
