/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.controller.FrontController;
import com.mycompany.mavenproject1.view.Screen;

/**
 *
 * @author dam2_alu05@inf.ald
 */
public class Main {

    public static void main(String[] args) {
        Screen mainView= new Screen();
        FrontController fc= new FrontController(mainView,model);
        mainView.setVisible(true);
    }
}