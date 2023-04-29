package Artigos;

import Vintage.Artigos.Malas;
import Vintage.Artigos.Malas.Edicao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MalasTest {
    
    @Test
    public void testSetLargura(){
        Malas mala = new Malas();
        mala.setLargura(2.0);
        assertEquals(2.0, mala.getLargura());
    }

    @Test
    public void testSetAltura(){
        Malas mala = new Malas();
        mala.setAltura(2.0);
        assertEquals(2.0, mala.getAltura());
    }

    @Test
    public void testSetDesconto(){
        Malas mala = new Malas();
        mala.setDesconto(20);
        assertEquals(20, mala.getDesconto());
    }

    @Test
    public void testSetEdicao(){
        Malas mala = new Malas();
        mala.setEdicao(Edicao.PREMIUM);
        assertEquals(Edicao.PREMIUM, mala.getEdicao());
    }

    @Test
    public void testClone(){
        Malas mala = new Malas();
        mala.setAltura(2.0);
        Malas malaClone = mala.clone();
        assertEquals(malaClone.getAltura(), mala.getAltura());
    }

    @Test
    public void testEquals(){
        Malas mala = new Malas();
        mala.setAltura(2.0);
        Malas malaClone = mala.clone();
        assertEquals(malaClone, mala);
    }
}