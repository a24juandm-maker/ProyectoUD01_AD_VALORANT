/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.user;

import controller.FrontController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pjs;
import model.User;
import model.UserUtilities;
import model.Users;
import view.user.UserJDialog;

/**
 *
 * @author dam2_alu02@inf.ald
 */
public class LoginController {
    private UserJDialog view;
    private Users dataUsuarios;
    private Pjs dataPjs;
    private FrontController parentController;

    public LoginController(UserJDialog view, Users dataUsuarios, FrontController parentController, Pjs dataPjs) {
        this.view = view;
        this.dataUsuarios = dataUsuarios;
        this.parentController = parentController;
        this.dataPjs = dataPjs;
        
        this.view.setCancelJButtonActionListener(this.getCancelJButtonActionListener());
        this.view.setLoginJButtonActionListener(this.getLoginJButtonActionListener());
    }
    
    private ActionListener getCancelJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        };
        return al;
    }
    
    private ActionListener getLoginJButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameNewUser = view.getTextUserJTextField();
                String passwordNewUser = view.getTextPasswordJTextField();
                
                boolean match = false;
                List<User> listUsers = dataUsuarios.getListUsers();
                for (User usuarioExistente : listUsers) {
                    if (usuarioExistente.getUsuario().equals(nameNewUser) && usuarioExistente.getPassword().equals(passwordNewUser)) {
                        match = true;
                        break;
                    }
                }
                
                if(!match){
                    view.clearFields();
                    JOptionPane.showMessageDialog(view, "Usuario o Contraseña incorrectos","Error de Login",JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        view.clearFields();
                        JOptionPane.showMessageDialog(view, "Login Realizado");
                        UserUtilities.writePjsUserJSON("usuario", dataPjs.getListPj());
                        parentController.enableDisableLoginRegisterButton(false);
                        parentController.enableDisableEditCreateDeleteButton(true);
                        
                    } catch (IOException ex) {
                        System.getLogger(LoginController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
            }
        };
        return al;
    }
}
