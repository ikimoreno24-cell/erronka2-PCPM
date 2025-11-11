package APLIKAZIOA;

import java.util.ArrayList;

/**
 * Asteburua aukeratzeko klasea
 * Hilabeteak, asteburuak eta filmak kudeatzen ditu
 */
public class aukeratuAsteburua {
    private ArrayList<String> hilabeteak = new ArrayList<>();
    private ArrayList<String> asteburuak = new ArrayList<>();
    private ArrayList<String> asteburuZenbakiak = new ArrayList<>();
    private zinea zine;
    private ArrayList<pelikula> azkenPelikulak; 
    private String asteburua;
    private String asteburuZenbakia; 
    private String hilabetea;

    /**
     * Eraikitzailea
     * @param zine Zine objektua
     */
    public aukeratuAsteburua(zinea zine) {
        this.zine = zine;
        kargatuHilabeteak();
        kargatuAsteBuruak();
        kargatuAsteBuruZenbakiak();
        this.azkenPelikulak = new ArrayList<>(); 
    }
    
    /**
     * Hilabeteak kargatzen dugu
     */
    private void kargatuHilabeteak() {
        hilabeteak.add("Urtarrila");
        hilabeteak.add("Otsaila");
        hilabeteak.add("Martxoa");
        hilabeteak.add("Apirila");
        hilabeteak.add("Maiatza");
        hilabeteak.add("Ekaina");
        hilabeteak.add("Uztaila");
        hilabeteak.add("Abuztua");
        hilabeteak.add("Iraila");
        hilabeteak.add("Urria");
        hilabeteak.add("Azaroa");
        hilabeteak.add("Abendua");
    }
    
    /**
     * Asteburu zenbakiak kargatzen dugu
     */
    private void kargatuAsteBuruZenbakiak() {
        asteburuZenbakiak.add("Lehen asteburua");
        asteburuZenbakiak.add("Bigarren asteburua");
        asteburuZenbakiak.add("Hirugarren asteburua");
        asteburuZenbakiak.add("Laugarren asteburua"); 
    }
    
    /**
     * Asteburuko egunak kargatzen dugu
     */
    private void kargatuAsteBuruak() {
        asteburuak.add("Larunbata"); 
        asteburuak.add("Igandea");
    }
    
    /**
     * Hilabeteak erakusten dugu
     */
    public void erakutsiHilabeteak() {
        System.out.println("\nAukeratu hilabetea:");
        for (int i = 0; i < hilabeteak.size(); i++) {
            System.out.println((i + 1) + ". " + hilabeteak.get(i));
        }
    }
    
    /**
     * Asteburu zenbakiak erakusten dugu
     */
    public void erakutsiAsteburuZenbakiak() { 
        System.out.println("\nAukeratu zein asteburu:");
        for (int i = 0; i < asteburuZenbakiak.size(); i++) {
            System.out.println((i + 1) + ". " + asteburuZenbakiak.get(i));
        }
    }
    
    /**
     * Asteburuko egunak erakusten dugu
     */
    public void erakutsiAsteBuruak() {
        System.out.println("\nAukeratu asteburuko eguna:"); 
        for (int i = 0; i < asteburuak.size(); i++) {
            System.out.println((i + 1) + ". " + asteburuak.get(i));
        }
    }
    
    /**
     * Hilabetea lortzeko
     * @param index Hilabetearen indizea
     * @return Hilabetearen izena
     */
    public String getHilabetea(int index) {
        if (index >= 0 && index < hilabeteak.size()) { 
            this.hilabetea = hilabeteak.get(index); // GUARDAR
            return hilabeteak.get(index);
        }
        return null;
    }
    
    /**
     * Asteburuko eguna lortzeko
     * @param index Asteburuaren indizea
     * @return Asteburuaren izena
     */
    public String getAsteburua(int index) {
        if (index >= 0 && index < asteburuak.size()) {
            this.asteburua = asteburuak.get(index); // GUARDAR
            return asteburuak.get(index);
        }
        return null;
    }
    
    /**
     * Asteburu zenbakia lortzeko
     * @param index Asteburu zenbakiaren indizea
     * @return Asteburu zenbakiaren izena
     */
    public String getAsteburuZenbakia(int index) {
        if (index >= 0 && index < asteburuZenbakiak.size()) {
            this.asteburuZenbakia = asteburuZenbakiak.get(index); // GUARDAR
            return asteburuZenbakiak.get(index);
        }
        return null;
    }
    
    /**
     * 4 film ausaz erakusten dugu
     */
    public void erakutsiEgunekoFilmak() {
        System.out.println("\nAsteburuko pelikula aukerak (4 film ausaz):");

      
        if (asteburua == null || asteburuZenbakia == null || hilabetea == null) {
            System.out.println("ERROR: Datuak ez daude prest. Aukeratu lehenik data.");
            return;
        }

       
        pelikula[] proiekzioBerria = proiekzioa.lortuProiekzioa(asteburua, asteburuZenbakia, hilabetea, zine);

        this.azkenPelikulak.clear();
        for (pelikula p : proiekzioBerria) {
            if (p != null) {
                this.azkenPelikulak.add(p);
            }
        }
        
        for (int i = 0; i < this.azkenPelikulak.size(); i++) {
            pelikula p = this.azkenPelikulak.get(i);
            System.out.println((i + 1) + ". " + p.getKolorea() + p.getTitulua() + koloreak.RESET + 
                             " - Stock: " + p.getStock());
        }
    }

    /**
     * Aukeratutako filmak lortzeko
     * @return Aukeratutako pelikulen zerrenda
     */
    public ArrayList<pelikula> getAzkenPelikulak() {
        return azkenPelikulak;
    }

    /**
     * Hilabete kopurua lortzeko
     * @return Hilabete kopurua
     */
    public int getHilabeteKopurua() {
        return hilabeteak.size();
    }

    /**
     * Asteburu kopurua lortzeko
     * @return Asteburu kopurua
     */
    public int getAsteburuKopurua() {
        return asteburuak.size();
    }

    /**
     * Asteburu zenbaki kopurua lortzeko
     * @return Asteburu zenbaki kopurua
     */
    public int getAsteburuZenbakiKopurua() {
        return asteburuZenbakiak.size();
    }

    /**
     * Zinea lortzeko
     * @return Zine objektua
     */
    public zinea getZine() {
        return zine;
    }
    
    /**
     * Datuak garbitzeko (testetarako)
     */
    public void garbituDatuak() {
        this.asteburua = null;
        this.asteburuZenbakia = null;
        this.hilabetea = null;
        this.azkenPelikulak.clear();
    }
}