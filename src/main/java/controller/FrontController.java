/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.user.LoginController;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.Pjs;
import view.MainJFrame;
import view.user.UserJDialog;

/**
 *
 * @author W10-Portable
 */
public class FrontController {

    private MainJFrame view;
    private Pjs data;

    public FrontController(MainJFrame view, Pjs data) {
        this.view = view;
        this.view.setRegisterJButtonActionListener(this.getRegisterJButtonActionListener());
        this.view.setLoginJButtonActionListener(this.getLoginJButtonActionListener());
        this.view.setShowJButtonActionListener(this.getShowJButtonActionListener());
        this.view.setReturnJButtonActionListener(this.getReturnJButtonActionListener());
        this.data = data;
        
        this.view.setRegisterJButtonActionListener(this.getRegisterJButtonActionListener());
        this.view.setLoginJButtonActionListener(this.getLoginJButtonActionListener());
        view.setImageTitle(this.addTitleImage());

    }
    
    
    private ActionListener getRegisterJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Registrar");
                UserJDialog viewLogin = new UserJDialog(view,true);
                LoginController lc = new LoginController(viewLogin,data,FrontController.this);
                viewLogin.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener getLoginJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Login");
                UserJDialog viewLogin = new UserJDialog(view,true);
                LoginController lc = new LoginController(viewLogin,data,FrontController.this);
                viewLogin.setVisible(true);
            }
        };
        return al;
    }
    
    private ActionListener getShowJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Ver");
            }
        };
        return al;
    }
    
    private ActionListener getReturnJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Volver");
            }
        };
        return al;
    }



    private ImageIcon addTitleImage() {
        ImageIcon titleImage = null;
        try {

            String urlImage = "https://esportsbureau.com/wp-content/uploads/2020/04/valorant.jpg";

            //Cargar Imagen Titulo de internet
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlImage))
                    .build();

            //Cliente HTTP obtener imagen
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<InputStream> response;
            response = client.send(request,
                    HttpResponse.BodyHandlers
                            .ofInputStream());

            //Leemos Flujo Imagen
            InputStream inputStream = response.body();
            Image image = ImageIO.read(inputStream);

            //Tratamiento Imagen
            Image imageRedimensity = image.getScaledInstance(1000, 220, Image.SCALE_SMOOTH);

            // Creacion  ImageIcon redimensionado
            titleImage = new ImageIcon(imageRedimensity);

        } catch (IOException ex) {
            System.out.println("Fallo entrada/salida lectura  imagen");
        } catch (InterruptedException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return titleImage;
    }
}
