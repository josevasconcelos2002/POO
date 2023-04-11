package Artigos;

import com.sun.jdi.event.StepEvent;

public class Artigo {

    private enum Estado {
        NOVO,
        USADO
    }

    protected String codigo;
    private Estado estado;
    private double avaliacao; // só se usado
    private int nDonos; // só se usado
    private String descricao;
    private String marca;
    private double precoBase;
    private double precoCorrigido;
}
