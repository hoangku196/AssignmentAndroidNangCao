package com.example.assignment1.model;

public class CaHoc {
    private int sttCaHoc;
    private String thoiGian;

    public CaHoc(int sttCaHoc, String thoiGian) {
        this.sttCaHoc = sttCaHoc;
        this.thoiGian = thoiGian;
    }

    public int getStt() {
        return sttCaHoc;
    }

    public void setStt(int sttCaHoc) {
        this.sttCaHoc = sttCaHoc;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
