package Vintage.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import Vintage.Artigos.Artigo;

public class User implements Serializable {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private ArrayList<Artigo> produtosVendidos;
    private ArrayList<Artigo> produtosVenda;
    private ArrayList<Artigo> produtosComprados;
    private String infoVendas; // não tenho a certeza de como fazer isto
    private double valorVendas;

    public User() {
        this.codigo = -1;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = 0;
        this.produtosVendidos = new ArrayList<Artigo>();
        this.produtosVenda = new ArrayList<Artigo>();
        this.produtosComprados = new ArrayList<Artigo>();
        this.infoVendas = "";
        this.valorVendas = 0.0;
    }

    public User(int codigo, String email, String nome, String morada, int nif) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
    }

    public User(int codigo, String email, String nome, String morada, int nif, ArrayList<Artigo> produtosVendidos,
    ArrayList<Artigo> produtosVenda, ArrayList<Artigo> produtosComprados, String infoVendas, double valorVendas) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
        this.produtosVendidos = produtosVendidos;
        this.produtosVenda = produtosVenda;
        this.produtosComprados = produtosComprados;
        this.infoVendas = infoVendas;
        this.valorVendas = valorVendas;
    }

    public User(User u) {
        this.codigo = u.getCodigo();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.nif = u.getNif();
        this.produtosVendidos = u.getProdutosVendidos();
        this.produtosVenda = u.getProdutosVenda();
        this.produtosComprados = u.getProdutosComprados();
        this.infoVendas = u.getInfoVendas();
        this.valorVendas = u.getValorVendas();
    }

    public void addProdutoVendido(Artigo artigo){
        this.produtosVendidos.add(artigo);
    }

    public void removeProdutoVendido(Artigo artigo){
        if(this.produtosVendidos.contains(artigo)){
            this.produtosVendidos.remove(artigo);
        }
    }

    public void addProdutoVenda(Artigo artigo){
        this.produtosVenda.add(artigo);
    }

    public void removeProdutoVenda(Artigo artigo){
        if(this.produtosVenda.contains(artigo)){
            this.produtosVenda.remove(artigo);
        }
    }

    public void addProdutoComprado(Artigo artigo){
        this.produtosComprados.add(artigo);
    }

    public void removeProdutoComprado(Artigo artigo){
        if(this.produtosComprados.contains(artigo)){
            this.produtosComprados.remove(artigo);
        }
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public ArrayList<Artigo> getProdutosVendidos() {
        return this.produtosVendidos;
    }

    public void setProdutosVendidos(ArrayList<Artigo> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public ArrayList<Artigo> getProdutosVenda() {
        return this.produtosVenda;
    }

    public void setProdutosVenda(ArrayList<Artigo> produtosVenda) {
        this.produtosVenda = produtosVenda;
    }

    public ArrayList<Artigo> getProdutosComprados() {
        return this.produtosComprados;
    }

    public void setProdutosComprados(ArrayList<Artigo> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }

    public String getInfoVendas() {
        return this.infoVendas;
    }

    public void setInfoVendas(String infoVendas) {
        this.infoVendas = infoVendas;
    }

    public double getValorVendas() {
        return this.valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    @Override
    public String toString() {
        return "{Codigo=" + codigo +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", nif='" + nif + '\'' +
                ", produtosVendidos=" + produtosVendidos.toString() +
                ", produtosVenda=" + produtosVenda.toString() +
                ", produtosComprados=" + produtosComprados.toString() +
                ", infoVendas='" + infoVendas + '\'' +
                ", valorVendas=" + valorVendas +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return codigo == user.codigo && Double.compare(user.valorVendas, valorVendas) == 0
                && Objects.equals(email, user.email) && Objects.equals(nome, user.nome)
                && Objects.equals(morada, user.morada) && Objects.equals(nif, user.nif)
                && produtosVendidos.equals(user.produtosVendidos)
                && produtosVenda.equals(user.produtosVenda)
                && produtosComprados.equals(user.produtosComprados)
                && Objects.equals(infoVendas, user.infoVendas);
    }

    /* 
    @Override
    public int hashCode() {
        int result = Objects.hash(codigo, email, nome, morada, nif, infoVendas, valorVendas);
        result = 31 * result + Arrays.hashCode(produtosVendidos);
        result = 31 * result + Arrays.hashCode(produtosVenda);
        result = 31 * result + Arrays.hashCode(produtosComprados);
        return result;
    }
    */
    @Override
    public User clone() {
        return new User(this);
    }
}
