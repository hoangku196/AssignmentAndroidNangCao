package com.example.assignment1.model;

public class LichThi {
    private String maLichThi;
    private String sttCaHoc;
    private String ngayHoc;
    private String phong;
    private String tenGV;
    private String maDangKiMon;

    public LichThi(String maLichThi, String sttCaHoc, String ngayHoc, String phong, String tenGV, String maDangKiMon) {
        this.maLichThi = maLichThi;
        this.sttCaHoc = sttCaHoc;
        this.ngayHoc = ngayHoc;
        this.phong = phong;
        this.tenGV = tenGV;
        this.maDangKiMon = maDangKiMon;
    }

    public String getMaLichThi() {
        return maLichThi;
    }

    public void setMaLichThi(String maLichThi) {
        this.maLichThi = maLichThi;
    }

    public String getSttCaHoc() {
        return sttCaHoc;
    }

    public void setSttCaHoc(String sttCaHoc) {
        this.sttCaHoc = sttCaHoc;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getMaDangKiMon() {
        return maDangKiMon;
    }

    public void setMaDangKiMon(String maDangKiMon) {
        this.maDangKiMon = maDangKiMon;
    }
}
