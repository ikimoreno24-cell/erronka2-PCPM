package APLIKAZIOA;

import java.util.ArrayList;
import java.util.Collections;

public class proiekzioa {
    private static pelikula[][] filmakGordeta = new pelikula[100][4];
    private static String[] proiekzioKey = new String[100];
    private static int proiekzioKop = 0;

    public static pelikula[] lortuProiekzioa(String eguna, String zenbakia, String hilabetea, zinea zine) {
        String gakoa = sortuKey(eguna, zenbakia, hilabetea);

        for (int i = 0; i < proiekzioKop; i++) {
            if (proiekzioKey[i] != null && proiekzioKey[i].equals(gakoa)) {
                return filmakGordeta[i];
            }
        }

        pelikula[] pelikulaBerriak = sortu4FilmBerriak(zine);

        proiekzioKey[proiekzioKop] = gakoa;
        filmakGordeta[proiekzioKop] = pelikulaBerriak;
        proiekzioKop++;

        return pelikulaBerriak;
       
    }

    private static String sortuKey(String eguna, String zenbakia, String hilabetea) {
        String zenbakiSinplea = zenbakia.replace("Lehen asteburua", "1")
                .replace("Bigarren asteburua", "2")
                .replace("Hirugarren asteburua", "3")
                .replace("Laugarren asteburua", "4"); 

        return eguna + "-" + zenbakiSinplea + "-" + hilabetea;
    }

    private static pelikula[] sortu4FilmBerriak(zinea zine) {
        ArrayList<pelikula> filmaGuztiak = new ArrayList<>();
        for (gelak gela : zine.getGelak()) {
            filmaGuztiak.addAll(gela.getPelikulak());
        }
        Collections.shuffle(filmaGuztiak);

        pelikula[] emaitza = new pelikula[4];
        for (int i = 0; i < 4 && i < filmaGuztiak.size(); i++) { 
            emaitza[i] = filmaGuztiak.get(i);
        }
        return emaitza;
    }

    public static void erakutsiProiekzioGuztiak() {
        System.out.println("\nProiekzio guztiak (" + proiekzioKop + ")");
        for (int i = 0; i < proiekzioKop; i++) {
            System.out.println("Proiekzioa " + (i + 1) + ": " + proiekzioKey[i]);
            for (int j = 0; j < filmakGordeta[i].length && filmakGordeta[i][j] != null; j++) {
                System.out.println("  - " + filmakGordeta[i][j].getTitulua());
            }
        }
    }
}