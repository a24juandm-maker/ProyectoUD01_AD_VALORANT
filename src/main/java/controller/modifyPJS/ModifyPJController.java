/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.modifyPJS;

import controller.FrontController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pjs;
import view.modifyPjs.CreateAndEditPJDialog;

/**
 *
 * @author Christian
 */
public class ModifyPJController {

    private CreateAndEditPJDialog view;
    private Pjs dataPjs;
    public ModifyPJController(CreateAndEditPJDialog modify, Pjs dataPjs, FrontController aThis) {
        this.view = modify;
        this.dataPjs = dataPjs;
        this.view.setTitleCreateAndEditJLabel("Editar agente");
        this.view.setTextCrearJButton("Editar");
        this.view.enableDisablePlantillaJLabel(false);
        this.view.enableDisableComboBoxPlantilla(false);
    }
    
    private ActionListener addEditActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
}
