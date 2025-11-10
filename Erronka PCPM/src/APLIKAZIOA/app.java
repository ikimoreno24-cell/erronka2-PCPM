/**
 * File hau aplikazio prinzipala da
 */
package APLIKAZIOA;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hashmap da ipintzeko key eta value bat, kasu honetan izango da String eta ArrayList baten artean
 * non "Astelehena" izango da key (giltza) eta 'astelehena' (lista) sartzen zaio value (balioa) bezala
 * 
 * Aplikazio nagusiaren klasea, zineko sarrerak erosteko eta informazioa kontsultatzeko aukera ematen duena.
 * 
 * Funtzionalitate nagusiak:
 * - Asteko egunetan gelak eta pelikulak kontsultatu eta sarrerak erosi.
 * - Asteburuko datak aukeratu eta sarrerak erosi.
 * - Zinearen informazio orokorra, kokapena eta ordutegia kontsultatu.
 * 
 * Egutegia HashMap batean gordetzen da, non egun bakoitzak gelaren indizeen zerrenda bat daukan.
 * 
 * @author ikaperez25
 */
public class app {  
    private static HashMap<String, ArrayList<Integer>> egutegia = new HashMap<>();
    
    /**
     * Agurra bueltatzen du - Test bat
     * @return "Kaixo" string-a
     */
    static String agurra() {
        return "Kaixo";
    }
    
    /**
     * Egutegia hasieratzen dugu
     */
    static {
        ArrayList<Integer> astelehena = new ArrayList<>();
        astelehena.add(4);
        astelehena.add(2); 
        egutegia.put("Astelehena", astelehena);
        
        ArrayList<Integer> asteartea = new ArrayList<>();
        asteartea.add(0);
        asteartea.add(1); 
        egutegia.put("Asteartea", asteartea);
        
        ArrayList<Integer> asteazkena = new ArrayList<>();
        asteazkena.add(3); 
        asteazkena.add(2);
        egutegia.put("Asteazkena", asteazkena);
        
        ArrayList<Integer> osteguna = new ArrayList<>();
        osteguna.add(1);
        osteguna.add(4); 
        egutegia.put("Osteguna", osteguna);
        
        ArrayList<Integer> ostirala = new ArrayList<>();
        ostirala.add(0);
        ostirala.add(3); 
        ostirala.add(4); 
        egutegia.put("Ostirala", ostirala);
    }
    
    /**
     * Aplikazioaren hasiera puntua
     * Menu nagusia erakusten du eta erabiltzailearen aukerak prozesatzen ditu
     * @param args Komando-lerroko argumentuak
     */
    public static void main(String[] args) {
        // Objektuak sortu
        hasierakoMenua menu = new hasierakoMenua();
        zinea cine = new zinea();
        aukeratuAsteburua asteburuaAukeraketa = new aukeratuAsteburua(cine);
        Scanner sc = new Scanner(System.in);
        
        // Menuaren atala aukeratzeko
        while (menu.dagoProgramaMartxan()) {
            menu.erakutsiMenua();
            int opzioa = sc.nextInt();
            
            // Aukera balioztatzen dugu
            if (!menu.aukeraBaliozkoaDa(opzioa)) {
                System.out.println("Zenbakia ez da baliozkoa");
                continue;
            }
            
            String aukeratutakoa = menu.getMenuNagusia().get(opzioa - 1);
            
            // Menua prozesatzen dugu
            if (aukeratutakoa.equals("Asteko egunak")) {
                prozesatuAstekoEgunak(cine, sc);
            } else if (aukeratutakoa.equals("Informazio orokorra")) {
                erakutsiInformazioOrokorra(cine);
            } else if (aukeratutakoa.equals("Kokapena")) {
                erakutsiKokapena();
            } else if (aukeratutakoa.equals("Ordutegia")) {
                erakutsiOrdutegia();
            } else if (aukeratutakoa.equals("Aukeratu data (asteburuak)")) {
                prozesatuAsteburuaAukeraketa(asteburuaAukeraketa, sc);
            } else if (aukeratutakoa.equals("Itxi")) {
                menu.itxiPrograma();
                System.out.println("Agur!");
            }
        }
        sc.close();
    }
    
    /**
     * Asteburua aukeratzeko prozesua
     * @param asteburuaAukeraketa Asteburua aukeratzeko objektua
     * @param sc Scanner objektua sarrera irakurtzeko
     */
    private static void prozesatuAsteburuaAukeraketa(aukeratuAsteburua asteburuaAukeraketa, Scanner sc) {
        asteburuaAukeraketa.erakutsiHilabeteak();
        int hilabeteAukera = sc.nextInt();
        
        // Hilabetea balioztatzen dugu
        if (hilabeteAukera < 1 || hilabeteAukera > asteburuaAukeraketa.getHilabeteKopurua()) {
            System.out.println("Hilabete okerra aukeratu duzu");
            return;
        }
        
        String hilabetea = asteburuaAukeraketa.getHilabetea(hilabeteAukera - 1);
        System.out.println("Aukeratu duzun hilabetea: " + hilabetea);
        
        asteburuaAukeraketa.erakutsiAsteburuZenbakiak();
        int asteburuZenbakiAukera = sc.nextInt();
        
        // Zenbakia balioztatzen dugu
        if (asteburuZenbakiAukera < 1 || asteburuZenbakiAukera > asteburuaAukeraketa.getAsteburuZenbakiKopurua()) {
            System.out.println("Asteburu zenbakia okerra aukeratu duzu");
            return;
        }
        
        String asteburuZenbakia = asteburuaAukeraketa.getAsteburuZenbakia(asteburuZenbakiAukera - 1);
        
        asteburuaAukeraketa.erakutsiAsteBuruak();
        int asteburuAukera = sc.nextInt();
        
        // Asteburua balioztatzen dugu
        if (asteburuAukera < 1 || asteburuAukera > asteburuaAukeraketa.getAsteburuKopurua()) {
            System.out.println("Asteburuko eguna okerra aukeratu duzu");
            return;
        }
        
        String asteburua = asteburuaAukeraketa.getAsteburua(asteburuAukera - 1);
        
        System.out.println("\nAukeratu duzun data: " + asteburua + ", " + asteburuZenbakia.toLowerCase() + " " + hilabetea + "n");
        
        asteburuaAukeraketa.erakutsiEgunekoFilmak();
        
        // Sarrerak erosteko galdetu
        System.out.println("\nErosi sarrerak asteburu honetarako? (Bai/Ez)");
        sc.nextLine(); 
        String erantzuna = sc.nextLine();
        
        if (erantzuna.equalsIgnoreCase("Bai")) {
            prozesatuErosketaAsteburua(asteburuaAukeraketa.getAzkenPelikulak(), sc);
        } else {
            System.out.println("Itzuli menura...");
        }
    }
    
    /**
     * Asteburuko erosketa prozesatzen dugu
     * @param pelikulak Aukeratutako pelikulen zerrenda
     * @param sc Scanner objektua sarrera irakurtzeko
     */
    private static void prozesatuErosketaAsteburua(ArrayList<pelikula> pelikulak, Scanner sc) {
        System.out.println("\nAukeratu filma:");
        for (int i = 0; i < pelikulak.size(); i++) {
            pelikula p = pelikulak.get(i);
            System.out.println((i + 1) + ". " + p.getKolorea() + p.getTitulua() + koloreak.RESET + 
                             " - Stock: " + p.getStock());
        }
        
        int pelikulaAukera = sc.nextInt() - 1;
        
        // Filma balioztatzen dugu
        if (pelikulaAukera < 0 || pelikulaAukera >= pelikulak.size()) {
            System.out.println("Filma okerra aukeratu duzu.");
            return;
        }
        
        pelikula aukeratutakoPelikula = pelikulak.get(pelikulaAukera);
        
        System.out.println("Zenbat sarrera nahi dituzu?");
        int sarrerak = sc.nextInt();
        
        // Stocka balioztatzen dugu
        if (sarrerak >= 1 && sarrerak <= aukeratutakoPelikula.getStock()) {
            aukeratutakoPelikula.kenduStock(sarrerak);
            System.out.println("Erosketa ondo egin da!");
            System.out.println("Geratzen den stocka: " + aukeratutakoPelikula.getStock());
        } else {
            System.out.println("Sartutako sarrera kantitatea ez dugu disponible");
        }
    }
    
    /**
     * Asteko egunak prozesatzen dugu
     * @param cine Zine objektua
     * @param sc Scanner objektua sarrera irakurtzeko
     */
    private static void prozesatuAstekoEgunak(zinea cine, Scanner sc) {
        ArrayList<String> astekoegunak = new ArrayList<>();
        astekoegunak.add("Astelehena");
        astekoegunak.add("Asteartea");
        astekoegunak.add("Asteazkena");
        astekoegunak.add("Osteguna");
        astekoegunak.add("Ostirala");
        
        System.out.println("Aukeratu asteko eguna");
        for (int j = 0; j < astekoegunak.size(); j++) {
            System.out.println((j + 1) + ". " + astekoegunak.get(j));
        }
        
        int egunaAukera = sc.nextInt();
        // Eguna balioztatzen dugu
        if (egunaAukera < 1 || egunaAukera > astekoegunak.size()) {
            System.out.println("Sartutako zenbakia baliogabea da");
            return;
        }
        
        String eguna = astekoegunak.get(egunaAukera - 1);
        System.out.println("Aukeratu duzu: " + eguna);
        
        erakutsiEgunekoGelak(eguna, cine);
        prozesatuErosketa(eguna, cine, sc);
    }
    
    /**
     * Eguneko gelak erakusten dugu
     * @param eguna Aukeratutako eguna
     * @param cine Zine objektua
     */
    private static void erakutsiEgunekoGelak(String eguna, zinea cine) {
        System.out.println(eguna + "ko gelak eta pelikulak hauek dira:");
        
        ArrayList<Integer> egunekoGelak = egutegia.get(eguna);
        if (egunekoGelak != null) {
            for (int gelaIndex : egunekoGelak) {
                gelak gela = cine.getGela(gelaIndex);
                if (gela != null) {
                    gela.erakutsiPelikulak();
                }
            }
        }
    }
    
    /**
     * Erosketa prozesatzen dugu
     * @param eguna Aukeratutako eguna
     * @param cine Zine objektua
     * @param sc Scanner objektua sarrera irakurtzeko
     */
    private static void prozesatuErosketa(String eguna, zinea cine, Scanner sc) {
        ArrayList<Integer> egunekoGelak = egutegia.get(eguna);
        if (egunekoGelak == null || egunekoGelak.isEmpty()) {
            System.out.println("Ez dago gelarik " + eguna + "n");
            return;
        }
        
        System.out.println("Aukeratu gela:");
        for (int i = 0; i < egunekoGelak.size(); i++) {
            gelak gela = cine.getGela(egunekoGelak.get(i));
            System.out.println((i + 1) + ". " + gela.getIzena());
        }
        
        int gelaAukera = sc.nextInt() - 1;
        // Gela balioztatzen dugu
        if (gelaAukera < 0 || gelaAukera >= egunekoGelak.size()) {
            System.out.println("Gela okerra");
            return;
        }
        
        gelak aukeratutakoGela = cine.getGela(egunekoGelak.get(gelaAukera));
        
        System.out.println("Aukeratu filma:");
        aukeratutakoGela.erakutsiPelikulak();
        
        int pelikulaAukera = sc.nextInt() - 1;
        pelikula aukeratutakoPelikula = aukeratutakoGela.bilatuPelikula(pelikulaAukera);
        
        // Filma balioztatzen dugu
        if (aukeratutakoPelikula == null) {
            System.out.println("Filma okerra.");
            return;
        }
        
        System.out.println("Zenbat sarrera nahi dituzu?");
        int sarrerak = sc.nextInt();
        
        // Stocka balioztatzen dugu
        if (sarrerak >= 1 && sarrerak <= aukeratutakoPelikula.getStock()) {
            aukeratutakoPelikula.kenduStock(sarrerak);
            System.out.println("Erosketa ondo egin da");
            System.out.println("Geratzen den stocka:  " + aukeratutakoPelikula.getStock());
        } else {
            System.out.println("Sartutako sarrera kantitatea ez dugu disponible");
        }
    }
    
    /**
     * Informazio orokorra erakusten dugu
     * @param cine Zine objektua
     */
    private static void erakutsiInformazioOrokorra(zinea cine) {
        System.out.println("Hau(ek) dira gaurko filmak:");
        int pelikulaKopurua = 0;
        
        for (gelak gela : cine.getGelak()) {
            for (pelikula p : gela.getPelikulak()) {
                p.erakutsi();
                pelikulaKopurua++;
            }
        }
        
        System.out.println("Filma kopurua: " + pelikulaKopurua);
        System.out.println("Gela kopurua: " + cine.getGelaKopurua());
        System.out.println("Gelen izenak:");
        for (gelak gela : cine.getGelak()) {
            System.out.println("- " + gela.getIzena());
        }
    }
    
    /**
     * Kokapena erakusten dugu
     */
    private static void erakutsiKokapena() {
        System.out.println("Kokapena:");
        System.out.println("CINESA URBIL, Bo. Txiki-Erdi, 7, 20170 Usurbil, Gipuzkoa");
        System.out.println("Google Maps: https://maps.app.goo.gl/49cqJqFQa9R3NaGV6");
    }
    
    /**
     * Ordutegia erakusten dugu
     */
    private static void erakutsiOrdutegia() {
        System.out.println("Informazioa");
        System.out.println("Asteleheneko ordutegia: 16:00 - 22:00");
        System.out.println("Astearteko ordutegia: 16:00 - 23:00");
        System.out.println("Asteazkeneko ordutegia: 16:00 - 23:00");
        System.out.println("Osteguneko ordutegia: 16:00 - 23:00");
        System.out.println("Ostiraleko ordutegia: 16:00 - 00:00");
        System.out.println("Larunbateko ordutegia: 15:00 - 00:00");
        System.out.println("Igandeko ordutegia: 15:00 - 23:00");
    }
}