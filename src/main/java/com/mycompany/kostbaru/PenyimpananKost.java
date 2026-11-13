/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kostbaru;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.time.LocalDateTime;

/**
 *
 * @author resti
 */
public class PenyimpananKost {
    
     public static void catatAktivitas(String aktivitas) {
        FileWriter writer = null;

        try {
            writer = new FileWriter("log_kost.txt", true);
            writer.write(LocalDateTime.now() + " | "
                    + aktivitas + System.lineSeparator());

            System.out.println("Aktivitas berhasil dicatat.");

        } catch (IOException e) {
            System.out.println("Gagal menulis log: " + e.getMessage());

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Gagal menutup file log.");
            }
        }
    }

    public static void bacaAktivitas() {
        Scanner pembaca = null;

        try {
            File file = new File("log_kost.txt");
            pembaca = new Scanner(file);

            System.out.println("\n=== RIWAYAT AKTIVITAS KOST ===");

            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File log belum tersedia.");

        } finally {
            if (pembaca != null) {
                pembaca.close();
            }
        }
    }

    public static void simpanData(PengelolaKost pengelola) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("data_kost.ser"))) {

            output.writeObject(pengelola);
            System.out.println("Data kost berhasil disimpan.");

        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    public static PengelolaKost muatData() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("data_kost.ser"))) {

            PengelolaKost pengelola = (PengelolaKost) input.readObject();

            System.out.println("Data kost berhasil dimuat kembali.");
            return pengelola;

        } catch (FileNotFoundException e) {
            System.out.println("File data belum tersedia.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }

        return null;
    }
}