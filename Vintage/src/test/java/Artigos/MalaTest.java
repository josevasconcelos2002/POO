package Artigos;

import Vintage.Artigos.Mala;
import Vintage.Artigos.ArtigoSpecs.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MalaTest {
    
    @Test
    public void testSetLargura(){
        Mala mala = new Mala();
        mala.setLargura(2.0);
        assertEquals(2.0, mala.getLargura());
    }

    @Test
    public void testSetAltura(){
        Mala mala = new Mala();
        mala.setAltura(2.0);
        assertEquals(2.0, mala.getAltura());
    }

    @Test
    public void testSetDesconto(){
        Mala mala = new Mala();
        mala.setDesconto(20);
        assertEquals(20, mala.getDesconto());
    }

    @Test
    public void testSetEdicao(){
        Mala mala = new Mala();
        mala.setEdicao(Edicao.PREMIUM);
        assertEquals(Edicao.PREMIUM, mala.getEdicao());
    }

    @Test
    public void testClone(){
        Mala mala = new Mala();
        mala.setAltura(2.0);
        Mala malaClone = mala.clone();
        assertEquals(malaClone.getAltura(), mala.getAltura());
    }

    @Test
    public void testEquals(){
        Mala mala = new Mala();
        mala.setAltura(2.0);
        Mala malaClone = mala.clone();
        assertEquals(malaClone, mala);
    }
}