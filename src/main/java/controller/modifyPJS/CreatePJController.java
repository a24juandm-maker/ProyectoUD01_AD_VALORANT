/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.modifyPJS;

import controller.FrontController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import model.Hability;
import model.Pj;
import model.Pjs;
import view.modifyPjs.CreateAndEditPJDialog;

/**
 *
 * @author Christian
 */
public class CreatePJController {

    private CreateAndEditPJDialog view;
    private Pjs dataPjs;
    private FrontController fc;

    public CreatePJController(CreateAndEditPJDialog view, Pjs dataPjs, FrontController aThis) {
        this.view = view;
        this.dataPjs = dataPjs;
        this.fc = aThis;
        this.view.setCreateButtonActionListener(this.addCreateActionListener());
        this.view.setCancelButtonActionListener(this.addCancelActionListenr());
    }

    private ActionListener addCreateActionListener() {

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("hola");
                    
                    Pj nuevoAgent = createAgent();
                    dataPjs.getListPj().add(nuevoAgent);
                    fc.guardarDatosUsuario();
                    fc.addPjButtons(dataPjs.getListPj());
                    view.dispose();
                } catch (URISyntaxException | MalformedURLException ex) {
                    System.err.println(ex.getMessage());
                }
 
            }

            
        };
        return al;
    }

    private ActionListener addCancelActionListenr() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("presiono cancelar");
                view.dispose();
            }
        };
        return al;
    }
    
    private Pj createAgent() {
                String name = view.getNameAgent();
                List<Hability> hability = new ArrayList<>();

                String description = view.getDescriptionAgent();
                String displayImagePj = view.getImageIconSmallFace();
                String role = view.getRole();
                String greatPjImage = view.getImageDisplay();
                
                String hability1Name = view.getNameHability1();
                String hability1Description = view.getDescriptionHability1();
                String hability1Image = view.getImagenHability1();
                if(hability1Image.isBlank() || hability1Image.isEmpty() || hability1Image == null){
                    hability1Image = "https://cdn-icons-png.flaticon.com/512/5219/5219070.png";
                
                }
                Hability habilidad1 = new Hability(hability1Name, hability1Description, hability1Image);
                
                String hability2Name = view.getNameHability2();
                String hability2Description = view.getDescriptionHability2();
                String hability2Image = view.getImagenHability2();
                if(hability2Image.isBlank() || hability2Image.isEmpty() || hability2Image == null){
                    hability2Image = "https://cdn-icons-png.flaticon.com/512/5219/5219070.png";
                
                }
                Hability habilidad2 = new Hability(hability2Name, hability2Description, hability2Image);
                
                String hability3Name = view.getNameHability3();
                String hability3Description = view.getDescriptionHability3();
                String hability3Image = view.getImagenHability3();
                if(hability3Image.isBlank() || hability3Image.isEmpty() || hability3Image == null){
                    hability3Image = "https://cdn-icons-png.flaticon.com/512/5219/5219070.png";
                
                }
                Hability habilidad3 = new Hability(hability3Name, hability3Description, hability3Image);
                
                String hability4Name = view.getNameHability4();
                String hability4Description = view.getDescriptionHability4();
                String hability4Image = view.getImagenHability4();
                if(hability4Image.isBlank() || hability4Image.isEmpty() || hability4Image == null){
                    hability4Image = "https://cdn-icons-png.flaticon.com/512/5219/5219070.png";
                
                }
                Hability habilidad4 = new Hability(hability4Name, hability4Description, hability4Image);
                hability.add(habilidad4);
                hability.add(habilidad3);
                hability.add(habilidad2);
                hability.add(habilidad1);
                
                Pj nuevoPj = new Pj();
                List<Hability> habilidades = nuevoPj.getHability();
                
                /*if(hability1Image.isEmpty() || hability2Image.isEmpty() || hability3Image.isEmpty() || hability4Image.isEmpty()){
                    habilidades.get(0).setDisplayImageHability("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");
                    habilidades.get(1).setDisplayImageHability("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");
                    habilidades.get(2).setDisplayImageHability("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");
                    habilidades.get(3).setDisplayImageHability("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");
                } else {
                    habilidades.get(0).setDisplayImageHability(habilidades.get(0).getDisplayImageHability());
                    habilidades.get(1).setDisplayImageHability(habilidades.get(1).getDisplayImageHability());
                    habilidades.get(2).setDisplayImageHability(habilidades.get(2).getDisplayImageHability());
                    habilidades.get(3).setDisplayImageHability(habilidades.get(3).getDisplayImageHability());
                }*/
                if(name.isEmpty() || displayImagePj.isEmpty() && greatPjImage.isEmpty()){
                    nuevoPj.setName("Default_Name");
                    nuevoPj.setDisplayImagePj("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");
                    nuevoPj.setGreatPjImage("https://cdn-icons-png.flaticon.com/512/5219/5219070.png");  
                } else {
                    nuevoPj.setName(name);
                    nuevoPj.setDisplayImagePj(displayImagePj);
                    nuevoPj.setGreatPjImage(greatPjImage);
                }
                
                nuevoPj.setDescription(description);
                nuevoPj.setRole(role);
                
                nuevoPj.setHability(hability);
                return nuevoPj;
            }

}
