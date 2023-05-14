package Vintage.Artigos;

import Vintage.Transportadoras.Transportadora;
import Vintage.Artigos.ArtigoSpecs.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;

public class Sapatilha extends Artigo implements Serializable {

    private int tamanho;
    private boolean atacadores;
    private String cor;
    private LocalDate dataColecao;
    private int desconto; // só em sapatilhas usadas, e definido pelo vendedor && sapatilhas novas acima de 45
    private Edicao edicao; // para estes casos o valor desconto é acrescentado

    public Sapatilha(){
        super();
        this.tamanho = 38;
        this.atacadores = true;
        this.cor = "red";
        this.dataColecao = LocalDate.now();
        this.desconto = 0;
        this.edicao = Edicao.STANDARD;
    }

    public Sapatilha(String codigo,String descricao, String marca, double precoBase, Transportadora t, int tamanho, boolean atacadores, String cor, LocalDate dataColecao, int desconto, Edicao edicao){
        super(codigo, descricao, marca, precoBase,t);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataColecao = dataColecao;
        this.desconto = desconto;
        this.edicao = edicao;
    }

    public Sapatilha(String codigo, double avaliacao, int nDonos, String descricao, String marca, double precoBase, Transportadora t, int tamanho, boolean atacadores, String cor, LocalDate dataColecao, int desconto, Edicao edicao) {
        super(codigo, avaliacao, nDonos, descricao, marca, precoBase, t);
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

    public LocalDate getDataColecao(){
        return this.dataColecao;
    }

    public void setDataColecao(LocalDate dataColecao){
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
        Sapatilha s = new Sapatilha();
        s.codigo = super.getCodigo();
        s.atacadores = this.atacadores;
        s.cor = this.cor;
        s.dataColecao = this.dataColecao;
        s.desconto = this.desconto;
        s.edicao = this.edicao;
        s.tamanho = this.tamanho;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sapatilha sapatilha = (Sapatilha) o;
        return tamanho == sapatilha.tamanho && atacadores == sapatilha.atacadores && desconto == sapatilha.desconto && Objects.equals(cor, sapatilha.cor) && Objects.equals(dataColecao, sapatilha.dataColecao) && edicao == sapatilha.edicao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tamanho, atacadores, cor, dataColecao, desconto, edicao);
    }

    @Override
    public String toString() {
        String atacadores = null;
        if(this.atacadores){
            atacadores = "sim";
        }else{
            atacadores = "não";
        }
        return "Sapatilha {" +
                "tamanho=" + tamanho +
                ", atacadores=" + atacadores +
                ", cor='" + cor + '\'' +
                ", dataColecao=" + dataColecao +
                ", desconto=" + desconto +
                ", edicao=" + edicao +
                '}';
    }

    public void calculaPrecoSapatilha(){
        Sapatilha s = (Sapatilha) this;
        if(Estado.USADO == s.getEstado()) {
            if (s.getEdicao() == Edicao.STANDARD)
                s.setPrecoCorrigido(s.getPrecoBase() - (s.getPrecoBase() / s.getnDonos() * s.getAvaliacao()));
            else {
                s.setPrecoCorrigido(s.getPrecoBase() + (s.getPrecoBase() / s.getnDonos() * s.getAvaliacao()));   // que algoritmo usar?
            }
        }
    }
} 