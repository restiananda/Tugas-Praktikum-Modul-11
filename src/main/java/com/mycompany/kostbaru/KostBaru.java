/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kostbaru;

import java.util.Scanner;

public class KostBaru {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        PengelolaKost pengelola = PenyimpananKost.muatData();
        
        if (pengelola == null) {
            
            pengelola = new PengelolaKost();
            
            DataKamar kamar1 = new KamarPutraBaru(101, "Andi", 500000, true);
            DataKamar kamar2 = new KamarPutribaru(202, "Jena", 600000, true);
            DataKamar kamar3 = new KamarPutraBaru(103, "Satria", 550000, false);
            DataKamar kamar4 = new KamarVIPBaru(301, "Layla", 1000000, true);
            
            pengelola.tambahKamar(kamar1);
            pengelola.tambahKamar(kamar2);
            pengelola.tambahKamar(kamar3);
            pengelola.tambahKamar(kamar4);
            
            Penghuni penghuni1 = new Penghuni("P001", "Andi");
            Penghuni penghuni2 = new Penghuni("P002", "Jena");
            Penghuni penghuni3 = new Penghuni("P003", "Satria");
            
            pengelola.tambahPenghuni(penghuni1);
            pengelola.tambahPenghuni(penghuni2);
            pengelola.tambahPenghuni(penghuni3);
        
        } else {
            System.out.println("Data sebelumnya berhasil dimuat.");
        }

        TransaksiKost transaksi = new TransaksiKost();

        int pilihan = 0;

        while (pilihan != 8) {

            System.out.println();
            System.out.println("===============================");
            System.out.println("   SISTEM PENGELOLAAN KOST");
            System.out.println("===============================");
            System.out.println("1. Tampilkan Fasilitas Kost");
            System.out.println("2. Tampilkan Semua Kamar");
            System.out.println("3. Tampilkan Semua Penghuni");
            System.out.println("4. Proses Transaksi Kost");
            System.out.println("5. Simpan Data");
            System.out.println("6. Muat Data");
            System.out.println("7. Lihat Riwayat Aktivitas");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = input.nextInt();

                switch (pilihan) {

                    case 1:
                        pengelola.tampilkanFasilitas();
                        break;

                    case 2:
                        pengelola.tampilkanSemuaKamar();
                        break;

                    case 3:
                        pengelola.tampilkanSemuaPenghuni();
                        break;

                    case 4:
                        input.nextLine();
                        
                        System.out.print("Masukkan ID penghuni: ");
                        String id = input.nextLine();
                        
                        System.out.print("Masukkan nomor kamar: ");
                        int nomorKamar = input.nextInt();
                        
                        Penghuni penghuni = pengelola.cariPenghuni(id);
                        DataKamar kamar = pengelola.cariKamar(nomorKamar);
                        
                        if (penghuni != null && kamar != null) {
                            transaksi.prosesTransaksi(penghuni, kamar);
                            
                            PenyimpananKost.catatAktivitas("Transaksi kamar nomor " + kamar.getNomor());
                        } else {
                            System.out.println("Penghuni atau kamar tidak ditemukan.");
                        }
                        break;

                    case 5:
                        PenyimpananKost.simpanData(pengelola);
                        PenyimpananKost.catatAktivitas("Data kost disimpan.");
                        break;
                    
                    case 6:
                        PengelolaKost dataMuat = PenyimpananKost.muatData();
                        if (dataMuat != null) {
                            pengelola = dataMuat;
                        }
                        break;
                    
                    case 7:
                        PenyimpananKost.bacaAktivitas();
                        break;
                        
                    case 8:
                        System.out.println("Program selesai. Terima kasih.");
                        break;

                    default:
                        System.out.println("Pilihan menu tidak tersedia.");
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input.");
                input.nextLine();
            }
        }

        input.close();
    }
}