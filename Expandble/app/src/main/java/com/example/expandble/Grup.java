package com.example.expandble;

import java.util.ArrayList;

/**
 * Created by FATHUR on 7/6/2017.
 */

public class Grup {

    private String nama;

    private ArrayList<Child> item;

    public String getNama() {
        return nama;
        //getter
    }

    public void setNama(String nama) {
        this.nama = nama;
        //setter
    }

    public ArrayList<Child> getItem() {
        return item;
        //getter
    }

    public void setItem(ArrayList<Child> item) {
        this.item = item;
        //setter
    }
}