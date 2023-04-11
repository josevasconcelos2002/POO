package Artigos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArtigoTest {

    @Test
    public void testSetCodigo() {
        Artigo artigo = new Artigo();
        String codigo = "123";
        artigo.setCodigo(codigo);
        assertEquals(codigo, artigo.getCodigo());
    }

    @Test
    public void testSetEstado() {
        Artigo artigo = new Artigo();
        Artigo.Estado estado = Artigo.Estado.USADO;
        artigo.setEstado(estado);
        assertEquals(estado, artigo.getEstado());
    }

    @Test
    public void testSetAvaliacao() {
        Artigo artigo = new Artigo();
        double avaliacao = 3.5;
        artigo.setAvaliacao(avaliacao);
        assertEquals(avaliacao, artigo.getAvaliacao(), 0);
    }

    @Test
    public void testSetnDonos() {
        Artigo artigo = new Artigo();
        int nDonos = 2;
        artigo.setnDonos(nDonos);
        assertEquals(nDonos, artigo.getnDonos());
    }

    @Test
    public void testSetDescricao() {
        Artigo artigo = new Artigo();
        String descricao = "Descrição do artigo";
        artigo.setDescricao(descricao);
        assertEquals(descricao, artigo.getDescricao());
    }

    @Test
    public void testSetMarca() {
        Artigo artigo = new Artigo();
        String marca = "Marca do artigo";
        artigo.setMarca(marca);
        assertEquals(marca, artigo.getMarca());
    }

    @Test
    public void testSetPrecoBase() {
        Artigo artigo = new Artigo();
        double precoBase = 50.0;
        artigo.setPrecoBase(precoBase);
        assertEquals(precoBase, artigo.getPrecoBase(), 0);
    }

}
