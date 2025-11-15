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
import model.Pj;
import model.Pjs;
import view.modifyPjs.DelPJ;

/**
 *
 * @author Christian
 */
public class DeleteController {
    private DelPJ view;
    private Pjs dataPjs;
    private FrontController fc;
    
    public DeleteController(DelPJ delPJView, Pjs dataPjs, FrontController aThis) {
        this.view = delPJView;
        this.dataPjs = dataPjs;
        this.fc = aThis;
        
        
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
                String agentEliminate = view.getDelNameAgent();
                System.out.println(agentEliminate);
                boolean encontrado = false;
                List<Pj> listPjs = dataPjs.getListPj();
                Pj pjAeliminar = new Pj();
                for(Pj p : listPjs){
                    if(p.getName().equals(agentEliminate)){
                        System.out.println(agentEliminate + "encontrado se procede a eliminar");
                        encontrado = true;
                        pjAeliminar = p;
                    }
                }
                if(encontrado == true){
                    System.out.println("pjAeliminar" + pjAeliminar.getName());
                    
                    listPjs.remove(pjAeliminar);
                    fc.addPjButtons(listPjs);
                    
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
    
}
