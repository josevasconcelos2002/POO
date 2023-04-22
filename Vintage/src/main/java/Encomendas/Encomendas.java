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
        this.estado = estado.PENDENTE;
        this.dimensao = dimensao.MEDIA;
    }
}
