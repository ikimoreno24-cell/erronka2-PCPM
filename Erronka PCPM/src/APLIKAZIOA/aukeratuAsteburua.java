package APLIKAZIOA;
import java.util.Collections;
import java.util.ArrayList;

public class aukeratuAsteburua {
    private ArrayList<String> hilabeteak = new ArrayList<>();
    private ArrayList<String> asteburuak = new ArrayList<>();
    private ArrayList<String> asteburuZenbakiak = new ArrayList<>();
    private zinea zine;
    private ArrayList<pelikula> azkenPelikulak; 

    public aukeratuAsteburua(zinea zine) {
        this.zine = zine;
        kargatuHilabeteak();
        kargatuAsteBuruak();
        kargatuAsteBuruZenbakiak();
        this.azkenPelikulak = new ArrayList<>(); 
    }

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

    private void kargatuAsteBuruZenbakiak() {
        asteburuZenbakiak.add("Lehen asteburua");
        asteburuZenbakiak.add("Bigarren asteburua");
        asteburuZenbakiak.add("Hirugarren asteburua");
        asteburuZenbakiak.add("Laugarren asteburua"); 
    }

    private void kargatuAsteBuruak() {
        asteburuak.add("Larunbata"); 
        asteburuak.add("Igandea");
    }

    public void erakutsiHilabeteak() {
        System.out.println("\nAukeratu hilabetea:");
        for (int i = 0; i < hilabeteak.size(); i++) {
            System.out.println((i + 1) + ". " + hilabeteak.get(i));
        }
    }

    public void erakutsiAsteburuZenbakiak() { 
        System.out.println("\nAukeratu zein asteburu:");
        for (int i = 0; i < asteburuZenbakiak.size(); i++) {
            System.out.println((i + 1) + ". " + asteburuZenbakiak.get(i));
        }
    }

    public void erakutsiAsteBuruak() {
        System.out.println("\nAukeratu asteburuko eguna:"); 
        for (int i = 0; i < asteburuak.size(); i++) {
            System.out.println((i + 1) + ". " + asteburuak.get(i));
        }
    }

    public String getHilabetea(int index) {
        if (index >= 0 && index < hilabeteak.size()) { 
            return hilabeteak.get(index);
        }
        return null;
    }

    public String getAsteburua(int index) {
        if (index >= 0 && index < asteburuak.size()) {
            return asteburuak.get(index);
        }
        return null;
    }

    public String getAsteburuZenbakia(int index) {
        if (index >= 0 && index < asteburuZenbakiak.size()) {
            return asteburuZenbakiak.get(index);
        }
        return null;
    }

    public void erakutsiEgunekoFilmak() {
        System.out.println("\nAstebururako pelikula aukerak (4 film ausaz):");

        ArrayList<pelikula> filmaGuztiak = new ArrayList<>();

        for (gelak gela : zine.getGelak()) {
            filmaGuztiak.addAll(gela.getPelikulak());
        }

        Collections.shuffle(filmaGuztiak);

    
        this.azkenPelikulak.clear();
        for (int i = 0; i < 4; i++) {
            pelikula p = filmaGuztiak.get(i % filmaGuztiak.size()); 
            this.azkenPelikulak.add(p);
            System.out.println((i + 1) + ". " + p.getKolorea() + p.getTitulua() + koloreak.RESET + 
                             " - Stock: " + p.getStock());
        }
    }

 
    public ArrayList<pelikula> getAzkenPelikulak() {
        return azkenPelikulak;
    }

    public int getHilabeteKopurua() {
        return hilabeteak.size();
    }

    public int getAsteburuKopurua() {
        return asteburuak.size();
    }

    public int getAsteburuZenbakiKopurua() {
        return asteburuZenbakiak.size();
    }

    public zinea getZine() {
        return zine;
    }
}