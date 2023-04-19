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

    public TShirt(String codigo, String descricao, String marca, double precoBase, Tamanho tamanho, Padrao padrao, int desconto){
        super(codigo,descricao,marca,precoBase);
        this.tamanho = tamanho;
        this.padrao = padrao;
        this.desconto = desconto;
    }

    public TShirt(String codigo, double avaliacao, int nDonos, String descricao, String marca, double precoBase, Tamanho tamanho, Padrao padrao, int desconto){
        super(codigo, avaliacao, nDonos, descricao, marca, precoBase);
        this.tamanho = tamanho;
        this.padrao = padrao;
        this.desconto = desconto;
    }

    public Tamanho getTamanho(){
        return this.tamanho;
    }

    public void setTamanho(Tamanho tamanho){
        this.tamanho = tamanho;
    }

    public Padrao getPadrao(){
        return this.padrao;
    }

    public void setPadrao(Padrao padrao){
        this.padrao = padrao;
    }

    public int getDesconto(){
        return this.desconto;
    }

    public void setDesconto(int desconto){
        this.desconto = desconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TShirt tshirt = (TShirt) o;

        if (this.desconto != tshirt.desconto) return false;
        return (this.padrao == tshirt.padrao && this.tamanho == tshirt.tamanho);
    }

    @Override
    public Object clone(Object o){
        return new Object();
    }

    @Override
    public double calculaPrecoCorrigido(Object o){
        double preco_final = 0.0;
        TShirt t = (TShirt) o;
        if(Estado.USADO == super.getEstado())
        if(t.getPadrao() == Padrao.LISO) preco_final = t.getPrecoBase();

        return preco_final;
    }
}