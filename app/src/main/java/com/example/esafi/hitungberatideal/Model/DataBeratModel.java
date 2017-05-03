package com.example.esafi.hitungberatideal.Model;

import com.example.esafi.hitungberatideal.Helper.DataBerat;

/**
 * Created by esafi on 02/05/2017.
 */

public class DataBeratModel {

    private int id;
    private String nama;
    private String jenisKelamin;
    private int tinggi;
    private int berat;
    private double beratIdeal;
    private double bmi;
    private String kesimpulan;

    public DataBeratModel(int id, String nama, String jenisKelamin, int tinggi, int berat, double beratIdeal, double bmi, String kesimpulan) {
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tinggi = tinggi;
        this.berat = berat;
        this.beratIdeal = beratIdeal;
        this.bmi = bmi;
        this.kesimpulan = kesimpulan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public double getBeratIdeal() {
        return beratIdeal;
    }

    public void setBeratIdeal(double beratIdeal) {
        this.beratIdeal = beratIdeal;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getKesimpulan() {
        return kesimpulan;
    }

    public void setKesimpulan(String kesimpulan) {
        this.kesimpulan = kesimpulan;
    }
}
