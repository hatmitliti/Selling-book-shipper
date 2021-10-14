package com.example.book.Object;

public class Delivered {
    String TrangThai;
    String DiaChi;
    String TenNgNhan;
    String MaDH;
    String GiaoTien;

    public String getGiaoTien() {
        return GiaoTien;
    }

    public void setGiaoTien(String giaoTien) {
        GiaoTien = giaoTien;
    }



    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getTenNgNhan() {
        return TenNgNhan;
    }

    public void setTenNgNhan(String tenNgNhan) {
        TenNgNhan = tenNgNhan;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String maDH) {
        MaDH = maDH;
    }

    public Delivered() {
    }

    public Delivered(String trangThai, String diaChi, String tenNgNhan, String maDH, String giaoTien) {
        TrangThai = trangThai;
        DiaChi = diaChi;
        TenNgNhan = tenNgNhan;
        MaDH = maDH;
        GiaoTien = giaoTien;
    }
}
