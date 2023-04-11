package Artigos;

import java.util.Date;

public class Malas extends Artigo{

    private enum Edicao{
        STANDARD,
        PREMIUM
    }

    private double largura;
    private double altura;
    private int desconto; // inversamente proporcional à dimensão;
    private String material;
    private Date dataColecao;
    private Edicao edicao; // aumenta o valor X% ao ano (dependendo do tipo de mala)
}
