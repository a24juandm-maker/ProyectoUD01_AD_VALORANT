/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.modifyPJS;

import controller.FrontController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
                System.out.println("hola");

                Pj nuevoAgent = createAgent();
                dataPjs.getListPj().add(nuevoAgent);
                fc.addPjButtons(dataPjs.getListPj());
                view.dispose();
 
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
                ImageIcon displayImagePj = new ImageIcon(view.getImageIconSmallFace());
                String role = view.getRole();
                ImageIcon greatPjImage = new ImageIcon(view.getImageDisplay());
                
                String hability1Name = view.getNameHability1();
                String hability1Description = view.getDescriptionHability1();
                Hability habilidad1 = new Hability(name, description, new ImageIcon(""));
                
                String hability2Name = view.getNameHability2();
                String hability2Description = view.getDescriptionHability2();
                Hability habilidad2 = new Hability(name, description, new ImageIcon(""));
                
                String hability3Name = view.getNameHability3();
                String hability3Description = view.getDescriptionHability3();
                Hability habilidad3 = new Hability(name, description, new ImageIcon(""));
                
                String hability4Name = view.getNameHability4();
                String hability4Description = view.getDescriptionHability4();
                Hability habilidad4 = new Hability(name, description, new ImageIcon(""));
                hability.add(habilidad4);
                hability.add(habilidad3);
                hability.add(habilidad2);
                hability.add(habilidad1);
                
                Pj nuevoPj = new Pj();
                nuevoPj.setName(name);
                nuevoPj.setDescription(description);
                nuevoPj.setRole(role);
                nuevoPj.setDisplayImagePj(displayImagePj);
                nuevoPj.setGreatPjImage(greatPjImage);
                nuevoPj.setHability(hability);
                return nuevoPj;
            }

}
