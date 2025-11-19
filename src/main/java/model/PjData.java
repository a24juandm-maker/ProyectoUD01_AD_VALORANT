/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Christian
 */

import java.util.ArrayList;
import java.util.List;

public class PjData {
    private String id;
    private String name;
    private List<Hability> hability = new ArrayList<>();
    private String description;
    private String displayImagePj;
    private String role;
    private String greatPjImage;

    // Constructor vacío (para Gson)
    public PjData() {}

    // Constructor desde Pj (para convertir)
    public PjData(Pj pj) {
        this.id = pj.getId();
        this.name = pj.getName();
        this.description = pj.getDescription();
        this.displayImagePj = pj.getDisplayImagePj();
        this.role = pj.getRole();
        this.greatPjImage = pj.getGreatPjImage();
        if (pj.getHability() != null) {
            this.hability.addAll(pj.getHability());
        }
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Hability> getHability() { return hability; }
    public void setHability(List<Hability> hability) { this.hability = hability; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDisplayImagePj() { return displayImagePj; }
    public void setDisplayImagePj(String displayImagePj) { this.displayImagePj = displayImagePj; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getGreatPjImage() { return greatPjImage; }
    public void setGreatPjImage(String greatPjImage) { this.greatPjImage = greatPjImage; }

    // Convierte de vuelta a Pj (para cargar)
    public Pj toPj() {
        Pj pj = new Pj();
        pj.setId(this.id);
        pj.setName(this.name);
        pj.setDescription(this.description);
        pj.setDisplayImagePj(this.displayImagePj);
        pj.setRole(this.role);
        pj.setGreatPjImage(this.greatPjImage);
        pj.setHability(this.hability);
        return pj;
    }
}

