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

    public String getTitulua() {
        return titulua;
    }

    public void setTitulua(String titulua) {
        this.titulua = titulua;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getKolorea() {
        return kolorea;
    }

    public void erakutsi() {
        System.out.println(kolorea + titulua + koloreak.RESET);
    }

    public boolean baituStock(int kopurua) {
        return stock >= kopurua;
    }

    public void kenduStock(int kopurua) {
        if (baituStock(kopurua)) {
            stock -= kopurua;
        }
    }

    public void gehituStock(int kopurua) {
        stock += kopurua;
    }
}