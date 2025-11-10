package APLIKAZIOA;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Testak {

    @Test
    public void testagurra() { 
        String agurra = app.agurra(); 
        assertEquals("Kaixo", agurra);
    }
}
