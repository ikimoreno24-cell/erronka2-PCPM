package APLIKAZIOA;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testa{
    @Test
    public void testagurra(){
        String agurra = app.agurra();
        assertEquals("Kaixo", agurra);
    }
}