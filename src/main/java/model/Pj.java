/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.imageio.ImageIO;
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
    private ImageIO displayImagePj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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

    public ImageIO getDisplayImagePj() {
        return displayImagePj;
    }

    public void setDisplayImagePj(ImageIO displayImagePj) {
        this.displayImagePj = displayImagePj;
    }
    
    
    
    
    
}
