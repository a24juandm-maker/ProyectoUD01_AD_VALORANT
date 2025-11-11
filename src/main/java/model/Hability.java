/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.imageio.ImageIO;

/**
 *
 * @author christian
 */
class Hability {
    
    private String name;
    private String description;
    private String buttonAssigned;
    private ImageIO displayImageHability;

    public Hability(String name, String description, String buttonAssigned, ImageIO displayImageHability) {
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

    public ImageIO getDisplayImageHability() {
        return displayImageHability;
    }

    public void setDisplayImageHability(ImageIO displayImageHability) {
        this.displayImageHability = displayImageHability;
    }
    
    
}
