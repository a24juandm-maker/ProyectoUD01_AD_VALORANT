/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainJFrame;

/**
 *
 * @author W10-Portable
 */
public class FrontController {
    MainJFrame view;
    
    public FrontController(MainJFrame view){
        this.view = view;
        this.view.setRegisterJButtonActionListener(this.getRegisterJButtonActionListener());
        this.view.setLoginJButtonActionListener(this.getLoginJButtonActionListener());
        this.view.setShowJButtonActionListener(this.getShowJButtonActionListener());
        this.view.setReturnJButtonActionListener(this.getReturnJButtonActionListener());
    }
    
    private ActionListener getRegisterJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Registrar");
            }
        };
        return al;
    }
    
    private ActionListener getLoginJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Login");
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
}
