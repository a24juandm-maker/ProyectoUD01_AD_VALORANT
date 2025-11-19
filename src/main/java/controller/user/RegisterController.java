/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.user;

import controller.FrontController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.User;
import model.UserUtilities;
import model.Users;
import view.user.UserJDialog;

/**
 *
 * @author dam2_alu02@inf.ald
 */
public class RegisterController {

    private UserJDialog view;
    private Users dataUsuarios;
    private FrontController parentController;

    public RegisterController(UserJDialog view, Users dataUsuarios, FrontController parentController) {
        this.view = view;
        this.dataUsuarios = dataUsuarios;
        this.parentController = parentController;
        
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
                
                boolean exists = false;
                List<User> listUsers = dataUsuarios.getListUsers();
                for (User usuarioExistente : listUsers) {
                    if (usuarioExistente.getUsuario().equals(nameNewUser)) {
                        exists = true;
                        break;
                    }
                }
                
                if(!exists){
                    User usuarioNuevo = new User(nameNewUser,passwordNewUser);
                    dataUsuarios.getListUsers().add(usuarioNuevo);
                    
                    UserUtilities.writeUser(dataUsuarios.getListUsers());
                    view.clearFields();
                    JOptionPane.showMessageDialog(view, "Usuario creado con exito!");
                } else {
                    view.clearFields();
                    JOptionPane.showMessageDialog(view, "Este usuario ya existe","Error de Registro",JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        return al;
    }

    /*private void createUser() {
    
    String name = view.getNameUser();
    String password = view.getPassword();
    
    boolean exists = false;
    
    for (User u : listUsers) {
    if (u.getName().equals(name)) {
    exists = true;
    break;
    }
    }
    if (exists == false) {
    User user = new User(name, password);
    } else {
    System.out.println("El usuario ya existe");
    }
    
    }*/

}
