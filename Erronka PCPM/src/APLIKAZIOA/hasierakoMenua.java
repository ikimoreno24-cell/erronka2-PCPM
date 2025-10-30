package APLIKAZIOA;
import java.util.ArrayList;

public class hasierakoMenua {
    private ArrayList<String> hasierakoMenua;
    private boolean programaMartxan;
    
    public hasierakoMenua() {
        kargatuhasierakoMenuak();
        this.programaMartxan = true;  
    }
    
    private void kargatuhasierakoMenuak() {
        hasierakoMenua = new ArrayList<>();
        hasierakoMenua.add("Asteko egunak");
        hasierakoMenua.add("Informazio orokorra");
        hasierakoMenua.add("Kokapena");
        hasierakoMenua.add("Ordutegia");
        hasierakoMenua.add("Itxi");
    }
    
    public ArrayList<String> getMenuNagusia() {
        return new ArrayList<>(hasierakoMenua);
    }
    
 
    
    public boolean dagoProgramaMartxan() {
        return programaMartxan;
    }
    
    public void itxiPrograma() {
        this.programaMartxan = false;
    }
    
  
    public boolean aukeraBaliozkoaDa(int aukera) {
        return aukera >= 1 && aukera <= hasierakoMenua.size();
    }
    
    public boolean prozesatuAukera(int aukera) {
        if (!aukeraBaliozkoaDa(aukera)) {
            System.out.println("Zenbakia ez da baliozkoa");
            return true; 
        }
        
        String aukeratutakoa = hasierakoMenua.get(aukera - 1);
        System.out.println("Aukeratu duzu " + aukeratutakoa);
        
        if ("Itxi".equals(aukeratutakoa)) {
            itxiPrograma();
            return false;  
        }
        
     
        return true;  
    }
    
    public void erakutsiMenua() {
        System.out.println("\nMenu nagusia:");
        System.out.println("Aukeratu opzio bat");
        
        for (int i = 0; i < hasierakoMenua.size(); i++) {
            System.out.println((i + 1) + ". " + hasierakoMenua.get(i));
        }
    }
}