package Artigos;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Malas extends Artigo{

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

    public Malas(String codigo, String descricao, String marca, double precoBase, double largura, double altura, int desconto, String material, LocalDate dataColecao, Edicao edicao) {
        super(codigo, descricao, marca, precoBase);
        this.largura = largura;
        this.altura = altura;
        this.desconto = desconto;
        this.material = material;
        this.dataColecao = dataColecao;
        this.edicao = edicao;
    }

    public Malas(String codigo, double avaliacao, int nDonos, String descricao, String marca, double precoBase, double largura, double altura, int desconto, String material, LocalDate dataColecao, Edicao edicao) {
        super(codigo, avaliacao, nDonos, descricao, marca, precoBase);
        this.largura = largura;
        this.altura = altura;
        this.desconto = desconto;
        this.material = material;
        this.dataColecao = dataColecao;
        this.edicao = edicao;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public LocalDate getDataColecao() {
        return dataColecao;
    }

    public void setDataColecao(LocalDate dataColecao) {
        this.dataColecao = dataColecao;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Malas malas = (Malas) o;

        if (Double.compare(malas.largura, largura) != 0) return false;
        if (Double.compare(malas.altura, altura) != 0) return false;
        if (desconto != malas.desconto) return false;
        if (!Objects.equals(material, malas.material)) return false;
        if (!Objects.equals(dataColecao, malas.dataColecao)) return false;
        return edicao == malas.edicao;
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
                "Mala{" +
                super.toString() +
                "Malas{" +
                "largura=" + largura +
                ", altura=" + altura +
                ", desconto=" + desconto +
                ", material='" + material + '\'' +
                ", dataColecao=" + dataColecao +
                ", edicao=" + edicao +
                '}';
    }
}
