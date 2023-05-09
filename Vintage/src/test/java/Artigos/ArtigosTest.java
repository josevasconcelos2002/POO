package Artigos;

import static org.junit.jupiter.api.Assertions.*;

import Vintage.Artigos.Artigo;
import Vintage.Artigos.Artigos;
import Vintage.Artigos.Mala;
import org.junit.jupiter.api.Test;

public class ArtigosTest {

    @Test
    public void testSetListaDeArtigos(){
        Artigos lista = new Artigos();
        Artigos lista1 = new Artigos();
        Mala mala = new Mala();
        lista1.addArtigo(mala);
        lista.setListaDeArtigos(lista1.getListaDeArtigos());
        assertEquals(lista.getListaDeArtigos(),lista1.getListaDeArtigos());
    }
}
