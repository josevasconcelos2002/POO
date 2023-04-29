package Vintage.Encomendas;

import java.time.LocalDate;

import Vintage.IArtigo;
//import Artigos.Artigo;


public class Encomendas {
    
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
    private IArtigo[] artigos;
    private Estado estado;
    private Dimensao dimensao;
    private double precoFinal;
    private LocalDate dataExpedicao;

    public Encomendas(){
        this.artigos = null;
        this.precoFinal = 0.0;
        this.dataExpedicao = LocalDate.now();
        this.estado = Estado.PENDENTE;
        this.dimensao = Dimensao.MEDIA;
    }

    public Encomendas(IArtigo[] artigos,Estado estado, Dimensao dimensao, double precoFinal, LocalDate dataExpedicao){
        this.artigos = artigos;
        this.estado = estado;
        this.dimensao = dimensao;
        this.precoFinal = precoFinal;
        this.dataExpedicao = dataExpedicao;
    }

    public IArtigo[] getArtigos(){
        return this.artigos;
    }

    public void setArtigos(IArtigo[] artigos){
        this.artigos = artigos;
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

    public double getPrecoFInal(){
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
                "estado='" + this.estado + '\'' +
                ", dimensao=" + this.dimensao +
                ", precoFinal=" + this.precoFinal +
                ", dataExpedicao=" + this.dataExpedicao +
                '}';
    }

    @Override
    public boolean equals(Object o){
        boolean resultado = true;
        if(this == o) resultado = true;
        if(o == null || this.getClass() != o.getClass()) resultado = false;

        Encomendas encomenda = (Encomendas) o;

        if(this.estado != encomenda.estado) resultado = false;
        if(this.dimensao != encomenda.dimensao) resultado = false;
        if(Double.compare(this.precoFinal, encomenda.precoFinal) != 0) resultado = false;
        if(this.dataExpedicao.equals(encomenda.dataExpedicao) == false) resultado = false;
        return resultado;
    }

    public double calculaPrecoFinal(){
        // por cada artigo do array, se artigo.getEstado() == NOVO    + 0.5
        // se for usado, + 0.25
        double resultado = 0.0;
        return resultado;
    }
}
