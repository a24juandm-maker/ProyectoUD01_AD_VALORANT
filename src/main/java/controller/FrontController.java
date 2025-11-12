/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.user.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pjs;
import view.Login;
import view.MainJFrame;

/**
 *
 * @author W10-Portable
 */
public class FrontController {
    private MainJFrame view;
    private Pjs data;
    
    public FrontController(MainJFrame view, Pjs data){
        this.view = view;
        this.view.setRegisterJButtonActionListener(this.getRegisterJButtonActionListener());
        this.view.setLoginJButtonActionListener(this.getLoginJButtonActionListener());
        this.view.setShowJButtonActionListener(this.getShowJButtonActionListener());
        this.view.setReturnJButtonActionListener(this.getReturnJButtonActionListener());
        
        ///// Pendiente de revisar con proyecto AldTic
        this.data = data;
    }
    
    private ActionListener getRegisterJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Registrar");
                Login viewLogin = new Login(view,true);
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
                Login viewLogin = new Login(view,true);
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
    
    
}
