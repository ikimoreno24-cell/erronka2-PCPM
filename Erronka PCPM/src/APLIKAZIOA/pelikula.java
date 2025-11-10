package APLIKAZIOA;

/**
 * Pelikula klasea - Zineko pelikulak irudikatzeko
 * Pelikula bakoitzak titulua, stock-a eta kolorea ditu
 */
public class pelikula {
    private String titulua;
    private int stock;
    private String kolorea;

    /**
     * Pelikularen eraikitzailea
     * @param titulua Pelikularen titulua
     * @param kolorea Pelikularen kolorea
     */
    public pelikula(String titulua, String kolorea) {
        this.kolorea = kolorea;
        this.titulua = titulua;
        this.stock = 4;
    }

    /**
     * Titulua lortzeko
     * @return Pelikularen titulua
     */
    public String getTitulua() {
        return titulua;
    }

    /**
     * Titulua aldatzeko
     * @param titulua Pelikularen berria titulua
     */
    public void setTitulua(String titulua) {
        this.titulua = titulua;
    }

    /**
     * Stock-a lortzeko
     * @return Pelikularen stock kopurua
     */
    public int getStock() {
        return stock;
    }

    /**
     * Stock-a aldatzeko
     * @param stock Pelikularen berria stock kopurua
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Kolorea lortzeko
     * @return Pelikularen kolorea
     */
    public String getKolorea() {
        return kolorea;
    }

    /**
     * Pelikula erakusten dugu
     */
    public void erakutsi() {
        System.out.println(kolorea + titulua + koloreak.RESET);
    }

    /**
     * Stock dagoen ikusteko
     * @param kopurua Egiaztatuko den kopurua
     * @return true stock nahikoa badago, false bestela
     */
    public boolean baituStock(int kopurua) {
        return stock >= kopurua;
    }

    /**
     * Stock kentzen dugu
     * @param kopurua Kenduko den stock kopurua
     */
    public void kenduStock(int kopurua) {
        if (baituStock(kopurua)) {
            stock -= kopurua;
        }
    }

    /**
     * Stock gehitzen dugu
     * @param kopurua Gehituko den stock kopurua
     */
    public void gehituStock(int kopurua) {
        stock += kopurua;
    }
}