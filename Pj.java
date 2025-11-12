/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author christian
 */
public class Pj extends JButton{
    private String id;
    private String name;
    private List<Hability> hability;

    
    private String description;
    private ImageIcon displayImagePj;
    private String role;
    private ImageIcon greatPjImage;

    public Pj() {
        this.id = "";
        this.name = "";
        this.hability = new ArrayList<>();
        this.description = "";
        this.role = "";
    }

    public Pj(String id, String name, List<Hability> hability, String description, ImageIcon displayImagePj, String role) {
        this.id = id;
        this.name = name;
        this.hability = hability;
        this.description = description;
        this.displayImagePj = displayImagePj;
        this.role = role;
    }
     
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<Hability> getHability() {
        return hability;
    }

    public void setHability(List<Hability> hability) {
        this.hability = hability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageIcon getDisplayImagePj() {
        return displayImagePj;
    }

    public void setDisplayImagePj(ImageIcon displayImagePj) {
        this.displayImagePj = displayImagePj;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ImageIcon getGreatPjImage() {
        return greatPjImage;
    }

    public void setGreatPjImage(ImageIcon greatPjImage) {
        this.greatPjImage = greatPjImage;
    }
    
    
    
    
}
