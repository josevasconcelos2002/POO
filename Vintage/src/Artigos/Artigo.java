package Artigos;

import com.sun.jdi.event.StepEvent;

import java.util.Objects;

public class Artigo {

    private enum Estado {
        NOVO,
        USADO
    }

    protected String codigo;
    private Estado estado;
    private double avaliacao; // só se USADO
    private int nDonos; // só se USADO
    private String descricao;
    private String marca;
    private double precoBase;
    private double precoCorrigido;

    public Artigo(){
        this.codigo = "";
        this.estado = null;
        this.avaliacao = -1;
        this.nDonos = -1;
        this.descricao = "";
        this.marca = "";
        this.precoBase = -1;
        this.precoCorrigido = -1;
    }

    public Artigo(String codigo, String descricao, String marca, double precoBase) {
        this.codigo = codigo;
        this.estado = Estado.NOVO;
        this.descricao = descricao;
        this.marca = marca;
        this.precoBase = precoBase;
    }

    public Artigo(String codigo, double avaliacao, int nDonos, String descricao, String marca, double precoBase) {
        this.codigo = codigo;
        this.estado = Estado.USADO;
        this.avaliacao = avaliacao;
        this.nDonos = nDonos;
        this.descricao = descricao;
        this.marca = marca;
        this.precoBase = precoBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getnDonos() {
        return nDonos;
    }

    public void setnDonos(int nDonos) {
        this.nDonos = nDonos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getPrecoCorrigido() {
        return precoCorrigido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artigo artigo = (Artigo) o;

        if (Double.compare(artigo.avaliacao, avaliacao) != 0) return false;
        if (nDonos != artigo.nDonos) return false;
        if (Double.compare(artigo.precoBase, precoBase) != 0) return false;
        if (Double.compare(artigo.precoCorrigido, precoCorrigido) != 0) return false;
        if (!codigo.equals(artigo.codigo)) return false;
        if (estado != artigo.estado) return false;
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
                "codigo='" + codigo + '\'' +
                ", estado=" + estado +
                ", avaliacao=" + avaliacao +
                ", nDonos=" + nDonos +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", precoBase=" + precoBase +
                ", precoCorrigido=" + precoCorrigido +
                '}';
    }
}
