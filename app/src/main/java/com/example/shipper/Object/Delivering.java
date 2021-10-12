package com.example.shipper.Object;

public class Delivering {
    String TrangThai,DiaChi,TenNgNhan,MaDH;

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

    public Delivering() {
    }

    public Delivering(String trangThai, String diaChi, String tenNgNhan, String maDH) {
        TrangThai = trangThai;
        DiaChi = diaChi;
        TenNgNhan = tenNgNhan;
        MaDH = maDH;
    }
}
