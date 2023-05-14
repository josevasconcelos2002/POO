package Vintage.Encomendas;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import Vintage.Artigos.Artigo;
import Vintage.Artigos.ArtigoSpecs;
import Vintage.Vintage;

public class Encomenda implements Serializable {

    protected enum Dimensao{
        GRANDE,
        MEDIA,
        PEQUENA
    }

    protected enum Estado{
        PENDENTE,
        FINALIZADA,
        EXPEDIDA
    }
    private ArrayList<Artigo> artigos;
    private Estado estado;
    private Dimensao dimensao;
    private double precoFinal;
    private LocalDate dataExpedicao;

    public Encomenda(){
        this.artigos = new ArrayList<Artigo>();
        this.precoFinal = 0.0;
        this.dataExpedicao = LocalDate.now();
        this.estado = Estado.PENDENTE;
        this.dimensao = Dimensao.MEDIA;
    }

    public Encomenda(ArrayList<Artigo> artigos, Estado estado, Dimensao dimensao, double precoFinal, LocalDate dataExpedicao){
        this.artigos = artigos;
        this.estado = estado;
        this.dimensao = dimensao;
        this.precoFinal = precoFinal;
        this.dataExpedicao = dataExpedicao;
    }

    public Encomenda(Encomenda e){
        this.artigos = e.getArtigos();
        this.estado = e.getEstado();
        this.precoFinal = e.getPrecoFinal();
        this.dimensao = e.getDimensao();
        this.dataExpedicao = e.getDataExpedicao();
    }

    public ArrayList<Artigo> getArtigos(){
        return this.artigos;
    }

    public void setArtigos(ArrayList<Artigo> artigos){
        this.artigos = artigos;
    }

    public void addArtigoEncomenda(Artigo artigo){
        this.artigos.add(artigo);
    }

    public void removeArtigoEncomenda(Artigo artigo){
        this.artigos.remove(artigo);
    }

    public Estado getEstado(){
        return this.estado;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public Dimensao getDimensao(){
        return this.dimensao;
    }

    public void setDimensao(Dimensao dimensao){
        this.dimensao = dimensao;
    }

    public double getPrecoFinal(){
        return this.precoFinal;
    }

    public void setPrecoFinal(double precoFinal){
        this.precoFinal = precoFinal;
    }

    public LocalDate getDataExpedicao(){
        return this.dataExpedicao;
    }

    public void setDataExpedicao(LocalDate dataExpedicao){
        this.dataExpedicao = dataExpedicao;
    }

    @Override
    public String toString(){
        return "Encomenda{" +
                "produtos= " + artigos.toString() +
                "estado='" + this.estado + '\'' +
                ", dimensao=" + this.dimensao +
                ", precoFinal=" + this.precoFinal +
                ", dataExpedicao=" + this.dataExpedicao +
                '}';
    }

    public String stringEncomenda(){
        return "{ Encomenda -> " + this.dimensao +" (" + this.artigos.size() + ") " + ", " + this.estado + ", " + this.dataExpedicao + " }";
    }

    @Override
    public boolean equals(Object o){
        boolean resultado = true;
        if(o == null || this.getClass() != o.getClass()) resultado = false;

        Encomenda encomenda = (Encomenda) o;

        if(!artigos.equals(encomenda.artigos)) resultado = false;
        if(this.estado != encomenda.estado) resultado = false;
        if(this.dimensao != encomenda.dimensao) resultado = false;
        if(Double.compare(this.precoFinal, encomenda.precoFinal) != 0) resultado = false;
        if(!this.dataExpedicao.equals(encomenda.dataExpedicao)) resultado = false;
        return resultado;
    }

    public double calculaPrecoExpedicao(){
        int size = artigos.size();
        double resultado = 0.0;
        if(size == 1){
            this.setDimensao(Dimensao.PEQUENA);
            resultado += Vintage.getBaseExpedicaoPequenas();
        }
        else if(size >= 2 && size <= 5){
            this.setDimensao(Dimensao.MEDIA);
            resultado += Vintage.getBaseExpedicaoMedias();
        }
        else if(size > 5){
            this.setDimensao(Dimensao.GRANDE);
            resultado += Vintage.getBaseExpedicaoGrandes();
        }
        return resultado;
    }

    public double calculaPrecoFinal(){
        double resultado = 0.0;
        for(Artigo artigo : artigos){
            if(artigo.getEstado() == ArtigoSpecs.Estado.NOVO) resultado += 0.5;
            if(artigo.getEstado() == ArtigoSpecs.Estado.USADO) resultado += 0.25;
        }
        resultado += calculaPrecoExpedicao() * (1 + Vintage.getExpedicaoImposto()); // qual formula usar?
        return resultado;
    }

    @Override
    public Encomenda clone(){
        return new Encomenda(this);
    }
}
