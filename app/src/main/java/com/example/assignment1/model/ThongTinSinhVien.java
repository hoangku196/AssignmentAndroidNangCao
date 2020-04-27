package com.example.assignment1.model;

public class ThongTinSinhVien {
    private String maSinhVien;
    private String maLopQuanLy;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String queQuan;
    private String ghiChu;
    private String email;

    public ThongTinSinhVien(String maSinhVien, String maLopQuanLy, String hoTen, String ngaySinh, String gioiTinh, String queQuan, String ghiChu, String email) {
        this.maSinhVien = maSinhVien;
        this.maLopQuanLy = maLopQuanLy;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ghiChu = ghiChu;
        this.email = email;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaLopQuanLy() {
        return maLopQuanLy;
    }

    public void setMaLopQuanLy(String maLopQuanLy) {
        this.maLopQuanLy = maLopQuanLy;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
