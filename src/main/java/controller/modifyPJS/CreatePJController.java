/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.modifyPJS;

import model.Pjs;
import view.modifyPjs.CreateAndEditPJDialog;

/**
 *
 * @author Christian
 */
public class CreatePJController {

    private CreateAndEditPJDialog view;
    private Pjs dataPjs;
    public CreatePJController(CreateAndEditPJDialog view, Pjs dataPjs) {
        this.view = view;
        this.dataPjs = dataPjs;
    }
    
}
