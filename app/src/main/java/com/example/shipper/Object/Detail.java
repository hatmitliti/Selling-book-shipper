package com.example.shipper.Object;

public class Detail {
    String MaDH,Tien;

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String maDH) {
        MaDH = maDH;
    }

    public String getTien() {
        return Tien;
    }

    public void setTien(String tien) {
        Tien = tien;
    }

    public Detail() {
    }

    public Detail(String maDH, String tien) {
        MaDH = maDH;
        Tien = tien;
    }

}
