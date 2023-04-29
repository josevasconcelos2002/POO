package Vintage.Artigos;

import java.time.LocalDate;
//import java.util.Date;
import java.util.Objects;

public class Mala extends Artigo{

    public enum Edicao{
        STANDARD,
        PREMIUM
    }

    private double largura;
    private double altura;
    private int desconto; // inversamente proporcional à dimensão;
    private String material;
    private LocalDate dataColecao;
    private Edicao edicao; // aumenta o valor X% ao ano (dependendo do tipo de mala)

    public Mala(){
        super();
    }

    public Mala(String codigo, String descricao, String marca, double precoBase, double largura, double altura, int desconto, String material, LocalDate dataColecao, Edicao edicao) {
        super(codigo, descricao, marca, precoBase);
        this.largura = largura;
        this.altura = altura;
        this.desconto = desconto;
        this.material = material;
        this.dataColecao = dataColecao;
        this.edicao = edicao;
    }

    public Mala(String codigo, double avaliacao, int nDonos, String descricao, String marca, double precoBase, double largura, double altura, int desconto, String material, LocalDate dataColecao, Edicao edicao) {
        super(codigo, avaliacao, nDonos, descricao, marca, precoBase);
        this.largura = largura;
        this.altura = altura;
        this.desconto = desconto;
        this.material = material;
        this.dataColecao = dataColecao;
        this.edicao = edicao;
    }

    public double getLargura() {
        return this.largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getDesconto() {
        return this.desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public LocalDate getDataColecao() {
        return this.dataColecao;
    }

    public void setDataColecao(LocalDate dataColecao) {
        this.dataColecao = dataColecao;
    }

    public Edicao getEdicao() {
        return this.edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Mala mala = (Mala) o;

        if (Double.compare(mala.largura, this.largura) != 0) return false;
        if (Double.compare(mala.altura, this.altura) != 0) return false;
        if (this.desconto != mala.desconto) return false;
        if (!Objects.equals(this.material, mala.material)) return false;
        if (!Objects.equals(this.dataColecao, mala.dataColecao)) return false;
        return this.edicao == mala.edicao;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(largura);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(altura);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + desconto;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (dataColecao != null ? dataColecao.hashCode() : 0);
        result = 31 * result + (edicao != null ? edicao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                "Mala {" +
                super.toString() +
                "Malas {" +
                "largura = " + this.largura +
                ", altura = " + this.altura +
                ", desconto = " + this.desconto +
                ", material = '" + this.material + '\'' +
                ", dataColecao = " + this.dataColecao +
                ", edicao = " + this.edicao +
                '}';
    }

    @Override
    public Mala clone(){
        Mala m = new Mala();
        m.altura = this.altura;
        m.dataColecao = this.dataColecao;
        m.desconto = this.desconto;
        m.edicao = this.edicao;
        m.largura = this.largura;
        m.material = this.material;
        return m;
    }

    public void calculaPrecoMala(){
        Mala m = (Mala) this;
        if(Estado.USADO == this.getEstado()){
            if(m.getEdicao() == Edicao.STANDARD) m.setPrecoCorrigido(m.getPrecoBase() - (m.getPrecoBase() / m.getnDonos() * m.getAvaliacao()));
            else{
                m.setPrecoCorrigido(m.getPrecoBase() + (m.getPrecoBase() / m.getnDonos() * m.getAvaliacao()));
            }
        }
    }
}