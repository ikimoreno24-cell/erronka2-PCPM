package APLIKAZIOA;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Testak {

    @Test
    public void testagurra() { 
        String agurra = app.agurra(); 
        assertEquals("Kaixo", agurra);
    }
    @Test
    public void testOpzioakMenuan() {
        hasierakoMenua menu = new hasierakoMenua();
     
        assertTrue(menu.getMenuNagusia().contains("Asteko egunak"));
        assertTrue(menu.getMenuNagusia().contains("Informazio orokorra"));
        assertTrue(menu.getMenuNagusia().contains("Itxi"));
    }
      @Test
    public void OpzioakMenua() {
        hasierakoMenua menu = new hasierakoMenua();
        
        assertTrue(menu.aukeraBaliozkoaDa(1)); ;//Assert true 1 baliozko aukera delako
        assertTrue(menu.aukeraBaliozkoaDa(3)); ;//Assert true 3 baliozko aukera delako
        assertFalse(menu.aukeraBaliozkoaDa(0));;//Assert false 0 ez delako baliozko aukera
        assertFalse(menu.aukeraBaliozkoaDa(10));//Assert false 10 ez delako baliozko aukera
    }
    @Test
    public void testItxiPrograma(){
        hasierakoMenua menu=new hasierakoMenua();
        assertTrue(menu.dagoProgramaMartxan());
        menu.itxiPrograma();
        assertFalse(menu.dagoProgramaMartxan());
    }

    @Test
    public void testKoloreak(){
        assertEquals("\u001B[36m", koloreak.CYAN);
        assertEquals("\u001B[32m", koloreak.GREEN);
        assertEquals("\u001B[31m", koloreak.RED);
        assertEquals("\u001B[33m", koloreak.YELLOW);
        assertEquals("\u001B[35m", koloreak.PURPLE);
        assertEquals("\u001B[0m", koloreak.RESET);
    }

    @Test
    public void sarrerakErosi(){
        pelikula p = new pelikula("Test Pelikula", koloreak.CYAN);
        int hasierakoStock = p.getStock();

        p.kenduStock(2);

        assertEquals(hasierakoStock-2,p.getStock() );
    }


    @Test
    public void pelikulaSortu(){
        pelikula p = new pelikula("Pelikularen izena", koloreak.GREEN);
        assertEquals("Pelikularen izena", p.getTitulua());
        assertEquals(koloreak.GREEN, p.getKolorea());
        assertEquals(4, p.getStock());
    }
@Test
public void testAsteburuarenEgunak(){
    zinea zine = new zinea();
    aukeratuAsteburua asteburua = new aukeratuAsteburua(zine);
    
    assertEquals(2, asteburua.getAsteburuKopurua()); //expected:2 2 egun duelako asteburuak
    assertEquals("Larunbata", asteburua.getAsteburua(0)); //Lehen asteburuko eguno 0 posizioa izan behar da
    assertEquals("Igandea", asteburua.getAsteburua(1));//Index 1 bigarren asteburuko eguna delako
}
}