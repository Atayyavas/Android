package com.example.androidveritabankullanm_sqlitedatabase;

public class kitap {
    int id;

    public kitap() {
    }

    String baslık;
    String yazar;

    public kitap(String baslık, String yazar) {
        this.baslık = baslık;
        this.yazar = yazar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslık() {
        return baslık;
    }

    public void setBaslık(String baslık) {
        this.baslık = baslık;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }
}
