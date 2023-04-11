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
/*
    public Sapatilha(){
        this.tamanho = 0;
        super.n_donos = 0;
        //this.avaliaçao = 0;
        this.premium = false;
        this.desconto = 0;
        this.preço = 0;
    }

    public Sapatilha(Sapatilha umaSapatilha){
        super.codigo = umaSapatilha.getCodigo();
        this.tamanho = umaSapatilha.getTamanho();
        super.novo = umaSapatilha.getNovo();
        super.n_donos = umaSapatilha.getNdonos();
        this.avaliacao = umaSapatilha.getAvaliaçao();
        this.premium = umaSapatilha.getPremium();
        this.marca = umaSapatilha.getMarca();
        this.descriçao = umaSapatilha.getDescriçao();
        this.desconto = umaSapatilha.getDesconto();
        this.preço = umaSapatilha.getPreço(); 
    }

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

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
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

    public String getCodigo(){
        return this.codigo;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public int getNdonos(){
        return this.n_donos;
    }

    public int getDesconto(){
        return this.desconto;
    }

    public float getPreço(){
        return this.preço;
    }

    public float getAvaliaçao(){
        return this.avaliaçao;
    }

    public boolean getPremium(){
        return this.premium;
    }

    public boolean getNovo(){
        return this.novo;
    }

    public String getDescriçao(){
        return this.descriçao;
    }

    public String getMarca(){
        return this.marca;
    }
    */
} 