package Encomendas;

import java.time.LocalDate;

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

    private Estado estado;
    private Dimensao dimensao;
    private double precoFinal;
    private LocalDate dataExpedicao;

    public Encomendas(){
        this.precoFinal = 0.0;
        //this.dataExpedicao =
        this.estado = Estado.PENDENTE;
        this.dimensao = Dimensao.MEDIA;
    }

    public Encomendas(Estado estado, Dimensao dimensao, double precoFinal, LocalDate dataExpedicao){
        this.estado = estado;
        this.dimensao = dimensao;
        this.precoFinal = precoFinal;
        this.dataExpedicao = dataExpedicao;
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
}
