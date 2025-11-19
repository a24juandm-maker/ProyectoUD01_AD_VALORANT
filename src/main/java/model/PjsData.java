/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Christian
 */

import java.util.ArrayList;
import java.util.List;

public class PjsData {
    private List<PjData> listPj = new ArrayList<>();

    public List<PjData> getListPj() {
        return listPj;
    }

    public void setListPj(List<PjData> listPj) {
        this.listPj = listPj;
    }
}