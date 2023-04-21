package Artigos;

import java.util.Date;

public class Sapatilha extends Artigo{

    private enum Edicao{
        STANDARD,
        PREMIUM
    }

    private int tamanho;
    private boolean atacadores;
    private String cor;
    private Date dataColecao;
    private int desconto; // só em sapatilhas usadas, e definido pelo vendedor && sapatilhas novas acima de 45
    private Edicao edicao; // para estes casos o valor desconto é acrescentado

    public Sapatilha(String codigo,String descricao, String marca, double precoBase, int tamanho, boolean atacadores, String cor, Date dataColecao, int desconto, Edicao edicao){
        super(codigo, descricao, marca, precoBase);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataColecao = dataColecao;
        this.desconto = desconto;
        this.edicao = edicao;
    }

    public Sapatilha(String codigo, double avaliacao, int nDonos, String descricao, String marca, double precoBase, int tamanho, boolean atacadores, String cor, Date dataColecao, int desconto, Edicao edicao) {
        super(codigo, avaliacao, nDonos, descricao, marca, precoBase);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataColecao = dataColecao;
        this.desconto = desconto;
        this.edicao = edicao;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public boolean getAtacadores(){
        return this.atacadores;
    }

    public void setAtacadores(boolean atacadores){
        this.atacadores = atacadores;
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public Date getDataColecao(){
        return this.dataColecao;
    }

    public void setDataColecao(Date dataColecao){
        this.dataColecao = dataColecao;
    }

    public int getDesconto(){
        return this.desconto;
    }

    public void setDesconto(int desconto){
        this.desconto = desconto;
    }

    public Edicao getEdicao(){
        return this.edicao;
    }

    public void setEdicao(Edicao edicao){
        this.edicao = edicao;
    }
  
    @Override
    public Sapatilha clone(){
        Sapatilha s = new Sapatilha(super.getCodigo(), super.getAvaliacao(), super.getnDonos(), super.getDescricao(), super.getMarca(), super.getPrecoBase(), this.getTamanho(), this.getAtacadores(), this.getCor(), this.getDataColecao(), this.getDesconto(), this.getEdicao());
        return s;
    }

    @Override
    public void setPrecoCorrigido(){
        Sapatilha m = (Sapatilha) this;
        if(Estado.USADO == super.getEstado()){
            if(m.getEdicao() == Edicao.STANDARD) super.setPrecoCorrigido(super.getPrecoBase() - (super.getPrecoBase()/super.getnDonos()*super.getAvaliacao()));
            else{
                super.setPrecoCorrigido(super.getPrecoBase() + (super.getPrecoBase()/super.getnDonos()*super.getAvaliacao()));   // que algoritmo usar?
            }
        }
    }
} 