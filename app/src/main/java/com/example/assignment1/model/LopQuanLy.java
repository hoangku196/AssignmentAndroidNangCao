package com.example.assignment1.model;

public class LopQuanLy {
    private String maLopQuanLy;
    private String maNganhQuanLy;
    private String lopQuanLy;
    private String khoaHoc;
    private int namNhapHoc;
    private int siSo;

    public LopQuanLy(String maLopQuanLy, String maNganhQuanLy, String lopQuanLy, String khoaHoc, int namNhapHoc, int siSo) {
        this.maLopQuanLy = maLopQuanLy;
        this.maNganhQuanLy = maNganhQuanLy;
        this.lopQuanLy = lopQuanLy;
        this.khoaHoc = khoaHoc;
        this.namNhapHoc = namNhapHoc;
        this.siSo = siSo;
    }

    public String getMaLopQuanLy() {
        return maLopQuanLy;
    }

    public void setMaLopQuanLy(String maLopQuanLy) {
        this.maLopQuanLy = maLopQuanLy;
    }

    public String getMaNganhQuanLy() {
        return maNganhQuanLy;
    }

    public void setMaNganhQuanLy(String maNganhQuanLy) {
        this.maNganhQuanLy = maNganhQuanLy;
    }

    public String getLopQuanLy() {
        return lopQuanLy;
    }

    public void setLopQuanLy(String lopQuanLy) {
        this.lopQuanLy = lopQuanLy;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }
}
