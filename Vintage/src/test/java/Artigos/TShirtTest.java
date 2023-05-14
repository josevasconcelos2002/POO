package Artigos;

import Vintage.Artigos.TShirt;
import Vintage.Artigos.ArtigoSpecs.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TShirtTest {

    @Test
    public void testSetTamanho(){
        TShirt tshirt = new TShirt();
        tshirt.setTamanho(Tamanho.L);
        assertEquals(Tamanho.L, tshirt.getTamanho());
    }

    @Test
    public void testSetPadrao(){
        TShirt tshirt = new TShirt();
        tshirt.setPadrao(Padrao.PALMEIRAS);
        assertEquals(Padrao.PALMEIRAS, tshirt.getPadrao());
    }

    @Test
    public void testSetDesconto(){
        TShirt tshirt = new TShirt();
        tshirt.setDesconto(30);
        assertEquals(30, tshirt.getDesconto());
    }

    @Test
    public void testClone(){
        TShirt tshirt = new TShirt();
        tshirt.setDesconto(30);
        TShirt tClone = tshirt.clone();
        assertEquals(tClone.getDesconto(), tshirt.getDesconto());
    }

    @Test
    public void testEquals(){
        TShirt tshirt = new TShirt();
        tshirt.setDesconto(30);
        TShirt tClone = tshirt.clone();
        assertEquals(tClone, tshirt);
    }
    
}
