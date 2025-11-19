/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.modifyPJS;

import controller.FrontController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Pj;
import model.Pjs;
import view.MainJFrame;
import view.modifyPjs.CreateAndEditPJDialog;

/**
 *
 * @author Christian
 */
public class ModifyPJController {

    private CreateAndEditPJDialog view;
    private MainJFrame viewMain;
    private Pjs dataPjs;
    private FrontController fc;
    public ModifyPJController(CreateAndEditPJDialog modify, Pjs dataPjs, FrontController aThis, MainJFrame viewMain) {
        this.view = modify;
        this.dataPjs = dataPjs;
        this.viewMain = viewMain;
        this.fc = aThis;
        this.view.setTitleCreateAndEditJLabel("Editar agente");
        this.view.setTextCrearJButton("Editar");
        this.view.enableDisablePlantillaJLabel(false);
        this.view.enableDisableComboBoxPlantilla(false);
        this.view.setCreateButtonActionListener(this.addEditActionListener());
        this.view.setCancelButtonActionListener(this.addCancelActionListener());
        
        getActualPj();
    }
    
    private ActionListener addEditActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textName = view.getNameAgent();
                    String textDescription = view.getDescriptionAgent();
                    String textImagenIcon = view.getImageIconSmallFace();
                    String textRol = view.getRole();
                    String textImageFullBody = view.getImageDisplay();
                    String textNameHability1 = view.getNameHability1();
                    String textNameHability2 = view.getNameHability2();
                    String textNameHability3 = view.getNameHability3();
                    String textNameHability4 = view.getNameHability4();
                    String textDescriptionHability1 = view.getDescriptionHability1();
                    String textDescriptionHability2 = view.getDescriptionHability2();
                    String textDescriptionHability3 = view.getDescriptionHability3();
                    String textDescriptionHability4 = view.getDescriptionHability4();
                    
                    List<Pj> listaPersonajes = dataPjs.getListPj();
                    for (Pj personaje : listaPersonajes) {
                        if (personaje.getName().equals(viewMain.getActualPj())) {
                            personaje.setName(textName);
                            personaje.setDescription(textDescription);
                            personaje.setRole(textRol);
                            try {
                                URI linkImageIcon = new URI(textImagenIcon);
                                URI linkImageFull = new URI(textImageFullBody);
                                ImageIcon newIcon = new ImageIcon(linkImageIcon.toURL());
                                //ImageIcon newFullBody = new ImageIcon(linkImageFull.toURL());
                                personaje.setIcon(newIcon);
                                personaje.setDisplayImagePj(linkImageFull.getPath());
                            } catch(Exception ex){
                                System.out.println(ex.getMessage());
                            }
                            personaje.getHability().get(0).setName(textNameHability1);
                            personaje.getHability().get(1).setName(textNameHability2);
                            personaje.getHability().get(2).setName(textNameHability3);
                            personaje.getHability().get(3).setName(textNameHability4);
                            personaje.getHability().get(0).setDescription(textDescriptionHability1);
                            personaje.getHability().get(1).setDescription(textDescriptionHability2);
                            personaje.getHability().get(2).setDescription(textDescriptionHability3);
                            personaje.getHability().get(3).setDescription(textDescriptionHability4);
                            break;
                        }
                    }
                    fc.addPjButtons(listaPersonajes);
                    view.dispose();
                    JOptionPane.showMessageDialog(viewMain, "El Agente ha sido editado");
                } catch (URISyntaxException | MalformedURLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        };
        return al;
    }
    private ActionListener addCancelActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }
    
    private void getActualPj(){
        boolean foundPj = false;
        List<Pj> listaPersonajes = dataPjs.getListPj();
        for (Pj personaje : listaPersonajes) {
            if (personaje.getName().equals(viewMain.getActualPj())) {
                foundPj = true;
                view.setNameAgent(personaje.getName());
                view.setDescriptionAgent(personaje.getDescription());
                view.setImageIconSmallFace(personaje.getDisplayImagePj());
                view.setRole(personaje.getRole());
                view.setImageDisplay(personaje.getGreatPjImage());

                view.setNameHability1(personaje.getHability().get(0).getName());
                view.setDescriptionHability1(personaje.getHability().get(0).getDescription());
                view.setNameHability2(personaje.getHability().get(1).getName());
                view.setDescriptionHability2(personaje.getHability().get(1).getDescription());
                view.setNameHability3(personaje.getHability().get(2).getName());
                view.setDescriptionHability3(personaje.getHability().get(2).getDescription());
                view.setNameHability4(personaje.getHability().get(3).getName());
                view.setDescriptionHability4(personaje.getHability().get(3).getDescription());
                break;
            } else {
                foundPj = false;
            }
        }

        if (!foundPj) {
            JOptionPane.showMessageDialog(view, "No se encontro el personaje", "Pj no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
}
