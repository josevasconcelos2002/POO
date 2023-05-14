package Artigos;

import Vintage.Artigos.Sapatilha;
import Vintage.Artigos.ArtigoSpecs.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class SapatilhaTest {
    
    @Test
    public void testSetTamanho(){
        Sapatilha s = new Sapatilha();
        s.setTamanho(38);
        assertEquals(38, s.getTamanho());
    }

    @Test
    public void testSetAtacadores(){
        Sapatilha s = new Sapatilha();
        s.setAtacadores(true);
        assertEquals(true, s.getAtacadores());
    }

    @Test
    public void testSetCor(){
        Sapatilha s = new Sapatilha();
        s.setCor("azul");
        assertEquals("azul", s.getCor());
    }

    @Test
    public void testSetDate(){
        Sapatilha s = new Sapatilha();
        s.setDataColecao(LocalDate.now());
        assertEquals(LocalDate.now(), s.getDataColecao());
    }

    @Test
    public void testSetDesconto(){
        Sapatilha s = new Sapatilha();
        s.setDesconto(0);
        assertEquals(0, s.getDesconto());
    }

    @Test
    public void testSetEdicao(){
        Sapatilha s = new Sapatilha();
        s.setEdicao(Edicao.STANDARD);
        assertEquals(Edicao.STANDARD, s.getEdicao());
    }

    @Test
    public void testClone(){
        Sapatilha s = new Sapatilha();
        s.setTamanho(37);
        Sapatilha sClone = s.clone();
        assertEquals(sClone.getTamanho(), s.getTamanho());
    }

    @Test
    public void testEquals(){
        Sapatilha s = new Sapatilha();
        s.setTamanho(36);
        Sapatilha sClone = s.clone();
        assertEquals(sClone, s);
    }
}
