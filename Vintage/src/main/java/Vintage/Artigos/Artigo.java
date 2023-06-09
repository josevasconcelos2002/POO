package Vintage.Artigos;

import Vintage.IArtigo;
import Vintage.Transportadoras.Transportadora;
import Vintage.Artigos.ArtigoSpecs.*;

import java.io.*;
import java.util.UUID;
public abstract class Artigo implements IArtigo, Serializable {

    protected String codigo;
    private Estado estado;
    private double avaliacao; // só se USADO
    private int nDonos; // só se USADO
    private String descricao;
    private String marca;
    private double precoBase;
    private double precoCorrigido;
    private Transportadora transportadora;

    public Artigo(){
        String codigoCompleto = UUID.randomUUID().toString();
        this.codigo = codigoCompleto.replaceAll("-", "").substring(0, 15);
        this.estado = Estado.NOVO;
        this.avaliacao = -1;
        this.nDonos = -1;
        this.descricao = "";
        this.marca = "";
        this.precoBase = -1;
        this.precoCorrigido = -1.0;
        this.transportadora = null;
    }

    public Artigo(String codigo, String descricao, String marca, double precoBase,Transportadora t) {
        this.codigo = codigo;
        this.estado = Estado.NOVO;
        this.descricao = descricao;
        this.marca = marca;
        this.precoBase = precoBase;
        this.precoCorrigido = -1.0;
        this.transportadora = t;
    }

    public Artigo(String codigo, double avaliacao, int nDonos, String descricao, String marca, double precoBase, Transportadora t) {
        this.codigo = codigo;
        this.estado = Estado.USADO;
        this.avaliacao = avaliacao;
        this.nDonos = nDonos;
        this.descricao = descricao;
        this.marca = marca;
        this.precoBase = precoBase;
        this.precoCorrigido = -1.0;
        this.transportadora = t;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }

    public Transportadora getArtigoTransportadora(){
        return this.transportadora;
    }

    public void setArtigoTransportadora(Transportadora t){
        this.transportadora = t;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public double getAvaliacao() {
        return this.avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public int getnDonos() {
        return this.nDonos;
    }

    public void setnDonos(int nDonos) {
        this.nDonos = nDonos;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public double getPrecoBase() {
        return this.precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    @Override
    public double getPrecoCorrigido() {
        return this.precoCorrigido;
    }

    public void setPrecoCorrigido(double precoCorrigido) {
        this.precoCorrigido = precoCorrigido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Artigo artigo = (Artigo) o;

        if (Double.compare(artigo.avaliacao, avaliacao) != 0) return false;
        if (this.nDonos != artigo.nDonos) return false;
        if (Double.compare(artigo.precoBase, this.precoBase) != 0) return false;
        if (Double.compare(artigo.precoCorrigido, this.precoCorrigido) != 0) return false;
        if (!codigo.equals(artigo.codigo)) return false;
        if (this.estado != artigo.estado) return false;
        if (!descricao.equals(artigo.descricao)) return false;
        return marca.equals(artigo.marca);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = codigo.hashCode();
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        temp = Double.doubleToLongBits(avaliacao);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + nDonos;
        result = 31 * result + descricao.hashCode();
        result = 31 * result + marca.hashCode();
        temp = Double.doubleToLongBits(precoBase);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precoCorrigido);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Artigo{" +
                "codigo='" + this.codigo + '\'' +
                ", estado=" + this.estado +
                ", avaliacao=" + this.avaliacao +
                ", nDonos=" + this.nDonos +
                ", descricao='" + this.descricao + '\'' +
                ", marca='" + this.marca + '\'' +
                ", precoBase=" + this.precoBase +
                ", precoCorrigido=" + this.precoCorrigido +
                '}';
    }

    @Override
    public abstract Artigo clone();
}