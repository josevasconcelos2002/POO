package Artigos;

public class TShirt extends Artigo{

    private enum Tamanho{
        S,
        M,
        L,
        XL
    }

    private enum Padrao{
        LISO,
        RISCAS,
        PALMEIRAS
    }

    private Tamanho tamanho;
    private Padrao padrao;
    private int desconto; //só existe em padrões riscas e palmeiras e é fixo a 50%
}
