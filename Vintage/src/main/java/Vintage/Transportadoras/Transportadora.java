package Vintage.Transportadoras;

import java.io.Serializable;
import java.util.Objects;

public class Transportadora implements Serializable {
    private String nome;
    private double precoExpedicao;

    public Transportadora(){
        this.nome = "";
        this.precoExpedicao = 0;
    }

    public Transportadora(String nome, double precoExpedicao){
        this.nome = nome;
        this.precoExpedicao = precoExpedicao;
    }

    public Transportadora(String nome){
        this.nome = nome;
        this.precoExpedicao = 0;
    }

    public Transportadora(Transportadora t){
        this.nome = t.getNome();
        this.precoExpedicao = t.getPrecoExpedicao();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoExpedicao() {
        return this.precoExpedicao;
    }

    public void setPrecoExpedicao(double precoExpedicao) {
        this.precoExpedicao = precoExpedicao;
    }

    @Override
    public String toString() {
        return "Transportadora{" +
                "nome='" + nome + '\'' +
                ", precoExpedicao=" + precoExpedicao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora that = (Transportadora) o;
        return Double.compare(that.precoExpedicao, precoExpedicao) == 0 && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, precoExpedicao);
    }

    public Transportadora clone(){
        return new Transportadora(this);
    }

    public String stringTransportadora(){
        return "{ Transportadora: " + this.nome + "}";
    }
}
