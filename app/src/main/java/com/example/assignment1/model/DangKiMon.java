package com.example.assignment1.model;

public class DangKiMon {
    private String maDangKiMon;
    private String maSinhVien;
    private String maLopMonHoc;

    public DangKiMon(String maDangKiMon, String maSinhVien, String maLopMonHoc) {
        this.maDangKiMon = maDangKiMon;
        this.maSinhVien = maSinhVien;
        this.maLopMonHoc = maLopMonHoc;
    }

    public String getMaDangKiMon() {
        return maDangKiMon;
    }

    public void setMaDangKiMon(String maDangKiMon) {
        this.maDangKiMon = maDangKiMon;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaLopMonHoc() {
        return maLopMonHoc;
    }

    public void setMaLopMonHoc(String maLopMonHoc) {
        this.maLopMonHoc = maLopMonHoc;
    }
}
