package APLIKAZIOA;

public class pelikula {
    private String titulua;
    private int stock;
    private String kolorea;

    public pelikula(String titulua, String kolorea) {
        this.kolorea = kolorea;
        this.titulua = titulua;
        this.stock = 4;
    }

    //Titulua lortzeko
    public String getTitulua() {
        return titulua;
    }

    //Titulua aldatzeko
    public void setTitulua(String titulua) {
        this.titulua = titulua;
    }

    //Stock-a lortzeko
    public int getStock() {
        return stock;
    }

    //Stock-a aldatzeko
    public void setStock(int stock) {
        this.stock = stock;
    }

    //Kolorea lortzeko
    public String getKolorea() {
        return kolorea;
    }

    //Pelikula erakusten dugu
    public void erakutsi() {
        System.out.println(kolorea + titulua + koloreak.RESET);
    }

    //Stock dagoen ikusteko
    public boolean baituStock(int kopurua) {
        return stock >= kopurua;
    }

    //Stock kentzen dugu
    public void kenduStock(int kopurua) {
        if (baituStock(kopurua)) {
            stock -= kopurua;
        }
    }

    //Stock gehitzen dugu
    public void gehituStock(int kopurua) {
        stock += kopurua;
    }
}