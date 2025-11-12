/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author christian
 */
public class Pjs {
    List<Pj> listPj;
    Set<String> listRoles = new HashSet<>();

    public Pjs(List listPj) {
        this.listPj = listPj;
    }

    public List getListPj() {
        return listPj;
    }

    public void setListPj(List listPj) {
        this.listPj = listPj;
    }
    public void addRole(String role){
        listRoles.add(role);
    }
}
