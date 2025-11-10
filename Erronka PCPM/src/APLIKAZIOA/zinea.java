package APLIKAZIOA;
import java.util.ArrayList;

/**
 * Zinearen klase nagusia
 * Gelak eta pelikulak kudeatzen ditu
 */
public class zinea {
    private ArrayList<gelak> gelenLista;
    
    /**
     * Eraikitzailea - Zinea eta bere datuak hasieratzen ditu
     */
    public zinea() {
        this.gelenLista = new ArrayList<>();
        kargatuDatuak();
    }
    
    /**
     * Filmak sartzeko bere izena eta kolorearekin eta bere gelan
     */
    public void kargatuDatuak() {
        gelak umeenGela = new gelak("Umeen gela", koloreak.CYAN);
        umeenGela.gehituPelikula(new pelikula("Lilo y Stitch ", koloreak.CYAN));
        umeenGela.gehituPelikula(new pelikula("Una pelicula de Minecraft ", koloreak.CYAN));
        umeenGela.gehituPelikula(new pelikula("Mufasa: El rey leon ", koloreak.CYAN));
        umeenGela.gehituPelikula(new pelikula("Como entrenar a tu dragon ", koloreak.CYAN));
        umeenGela.gehituPelikula(new pelikula("Sonic 3: La pelicula ", koloreak.CYAN));
        umeenGela.gehituPelikula(new pelikula("Blancanieves ", koloreak.CYAN));
        gelenLista.add(umeenGela);

        gelak superHeroienGela = new gelak("Superheroien gela ", koloreak.GREEN);
        superHeroienGela.gehituPelikula(new pelikula("Capitán América: Brave New World ", koloreak.GREEN));
        superHeroienGela.gehituPelikula(new pelikula("Thunderbolt ", koloreak.GREEN));
        gelenLista.add(superHeroienGela);

        gelak thrillerGela = new gelak("Thriller gela ", koloreak. RED);
        thrillerGela.gehituPelikula(new pelikula("Conclave ", koloreak.RED));
        thrillerGela.gehituPelikula(new pelikula("Misión: Imposible. Sentencia Final " , koloreak.RED));
        thrillerGela.gehituPelikula(new pelikula("Sirāt ", koloreak.RED));
        gelenLista.add(thrillerGela);

        gelak zientziFikzioGela = new gelak("Zientzia fikzio gela ", koloreak.YELLOW);
        zientziFikzioGela.gehituPelikula(new pelikula("Wolfgang ", koloreak.YELLOW));
        gelenLista.add(zientziFikzioGela);

        gelak komediaGela = new gelak("Komedia gela ", koloreak.PURPLE);
        komediaGela.gehituPelikula(new pelikula("Padre no hay más que uno 5 ", koloreak.PURPLE));
        komediaGela.gehituPelikula(new pelikula("El casoplon ", koloreak.PURPLE));
        komediaGela.gehituPelikula(new pelikula("Un funeral de locos ", koloreak.PURPLE));
        gelenLista.add(komediaGela);
    }
    
    /**
     * Gelak lortzeko
     * @return Gelen zerrenda
     */
    public ArrayList<gelak> getGelak() {
        return gelenLista;
    }
    
    /**
     * Gela bat lortzeko
     * @param index Gela lortzeko indizea
     * @return Aukeratutako gela, edo null indizea baliogabea bada
     */
    public gelak getGela(int index) {
        if (index >= 0 && index < gelenLista.size()) {
            return gelenLista.get(index);
        }
        return null;
    }
    
    /**
     * Gela kopurua lortzeko
     * @return Gelen kopurua
     */
    public int getGelaKopurua() {
        return gelenLista.size();
    }
}