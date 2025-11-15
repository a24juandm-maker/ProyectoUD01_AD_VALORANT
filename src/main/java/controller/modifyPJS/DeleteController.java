/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.modifyPJS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pjs;
import view.modifyPjs.DelPJ;

/**
 *
 * @author Christian
 */
public class DeleteController {
    private DelPJ view;
    private Pjs dataPjs;

    public DeleteController(DelPJ delPJView, Pjs dataPjs) {
        this.view = delPJView;
        this.dataPjs = dataPjs;
        
        this.view.setCancelarJButtonActionListener(this.addCancelActionListener());
        this.view.setEliminarJButtonActionListener(this.addDeleteActionListener());
    }
    
    private ActionListener addDeleteActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pendiente hacer");
                //recorrer dataPjs en busca del nombre introducido
                // tiene que ser igual
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
