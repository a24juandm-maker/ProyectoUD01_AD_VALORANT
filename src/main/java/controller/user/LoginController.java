/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.user;

import controller.FrontController;
import java.util.ArrayList;
import java.util.List;
import model.Pjs;
import model.User;
import view.Login;

/**
 *
 * @author dam2_alu02@inf.ald
 */
public class LoginController {
    private Login view;
    private Pjs data;
    private List<User> listUsers;
    private FrontController parentController;

    public LoginController(Login view, Pjs data, FrontController parentController) {
        this.view = view;
        this.data = data;
        listUsers = new ArrayList<>();
        this.parentController = parentController;

        
        recoveryPjs();
    }
    
    private void recoveryPjs() {
        listUsers = data.getListPj();
    }
    
    private void loginUser(){
        
        String name = view.getNameUser();
        String password = view.getPassword();

        boolean exists = false;

        for (User u : listUsers) {
            if (u.getName().equals(name)) {
                exists = true;
                break;
            }
        }
        if (exists == true) {
            System.out.println("Te has logueado correctamente");
        }
    }
    
    
}
