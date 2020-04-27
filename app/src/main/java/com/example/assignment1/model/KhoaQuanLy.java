package com.example.assignment1.model;

public class KhoaQuanLy {
    private String maKhoaQuanLy;
    private String tenNganh;
    private String tenKhoa;

    public KhoaQuanLy(String maKhoaQuanLy, String tenNganh, String tenKhoa) {
        this.maKhoaQuanLy = maKhoaQuanLy;
        this.tenNganh = tenNganh;
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoaQuanLy() {
        return maKhoaQuanLy;
    }

    public void setMaKhoaQuanLy(String maKhoaQuanLy) {
        this.maKhoaQuanLy = maKhoaQuanLy;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
