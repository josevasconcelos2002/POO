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
    /* 
    public float preçoUsada(Sapatilha umaSapatilha){
        float resultado = (float)0.0;
        float preço = this.getPreço();
        int n_donos = this.getNdonos();
        float estado = this.getAvaliaçao();
        if(!this.getPremium()){
            resultado = preço-(preço/(n_donos * estado));
        }
        else{
            resultado = preço+(preço/(n_donos * estado));
        }
        return resultado;
    }

    

    public void setNovo(Boolean novo){
        if(this.getNdonos() > 0 && novo == false){
            this.novo = novo;
        }
        if(novo == true && this.getNdonos()>0){
            this.novo = novo;
            this.n_donos = 0;
        }
        if(novo == false && this.getNdonos() == 0){
            this.novo = novo;
            this.n_donos = 1;   //depois o utilizador tem que atualizar este valor
        }
    }


    public void setNdonos(int n_donos){
        if(!this.getNovo() && n_donos > 0){
            this.n_donos = n_donos;
        }
        if(this.getNovo() && n_donos == 0){
            this.n_donos = n_donos;
        }
    }
    */   
} 