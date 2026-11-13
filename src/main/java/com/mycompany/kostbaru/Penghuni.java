/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kostbaru;

import java.io.Serializable;

/**
 *
 * @author resti
 */
public class Penghuni implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nama;

    public Penghuni(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanInfo() {
        System.out.println("ID Penghuni: " + id);
        System.out.println("Nama: " + nama);
    }
}