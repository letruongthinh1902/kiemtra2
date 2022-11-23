package com.example.firebase;

public class MainModel {
    String  Tenbai, Tencasi, Mota, Turl;

    MainModel(){

    }
    public MainModel(String tenbai, String tencasi, String mota, String turl) {
        Tenbai = tenbai;
        Tencasi = tencasi;
        Mota = mota;
        Turl = turl;
    }

    public String getTenbai() {
        return Tenbai;
    }

    public void setTenbai(String tenbai) {
        Tenbai = tenbai;
    }

    public String getTencasi() {
        return Tencasi;
    }

    public void setTencasi(String tencasi) {
        Tencasi = tencasi;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getTurl() {
        return Turl;
    }

    public void setTurl(String turl) {
        Turl = turl;
    }
}
