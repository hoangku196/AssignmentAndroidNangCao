package com.example.assignment1.model;

public class LopMonHoc {
    private String maLopMonHoc;
    private String maMonHoc;
    private String lopMonHoc;
    private int namHoc;
    private int hocKi;
    private int siSo;

    public LopMonHoc(String maLopMonHoc, String maMonHoc, String lopMonHoc, int namHoc, int hocKi, int siSo) {
        this.maLopMonHoc = maLopMonHoc;
        this.maMonHoc = maMonHoc;
        this.lopMonHoc = lopMonHoc;
        this.namHoc = namHoc;
        this.hocKi = hocKi;
        this.siSo = siSo;
    }

    public String getMaLopMonHoc() {
        return maLopMonHoc;
    }

    public void setMaLopMonHoc(String maLopMonHoc) {
        this.maLopMonHoc = maLopMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getLopMonHoc() {
        return lopMonHoc;
    }

    public void setLopMonHoc(String lopMonHoc) {
        this.lopMonHoc = lopMonHoc;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public int getHocKi() {
        return hocKi;
    }

    public void setHocKi(int hocKi) {
        this.hocKi = hocKi;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }
}
