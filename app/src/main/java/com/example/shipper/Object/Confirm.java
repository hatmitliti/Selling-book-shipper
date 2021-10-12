package com.example.shipper.Object;

public class Confirm {
    String MaDH,LyDo;

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String maDH) {
        MaDH = maDH;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String lyDo) {
        LyDo = lyDo;
    }

    public Confirm() {
    }

    public Confirm(String maDH, String lyDo) {
        MaDH = maDH;
        LyDo = lyDo;
    }
}
