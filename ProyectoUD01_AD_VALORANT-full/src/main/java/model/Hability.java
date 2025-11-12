/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author dam2_alu13@inf.ald
 */
public class Hability {
    private String name;
    private String description;
    private String buttonAssigned;
    private ImageIcon displayImageHability;

    public Hability(String name, String description, String buttonAssigned, ImageIcon displayImageHability) {
        this.name = name;
        this.description = description;
        this.buttonAssigned = buttonAssigned;
        this.displayImageHability = displayImageHability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonAssigned() {
        return buttonAssigned;
    }

    public void setButtonAssigned(String buttonAssigned) {
        this.buttonAssigned = buttonAssigned;
    }

    public ImageIcon getDisplayImageHability() {
        return displayImageHability;
    }

    public void setDisplayImageHability(ImageIcon displayImageHability) {
        this.displayImageHability = displayImageHability;
    }
}
