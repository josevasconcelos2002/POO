package Vintage.Users;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class User implements Serializable {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private int nif;
    private String [] produtosVendidos; // mudar para map ou list???
    private String [] produtosVenda;    // mudar para map ou list???
    private String [] produtosComprados;// mudar para map ou list???
    private String infoVendas; // não tenho a certeza de como fazer isto
    private double valorVendas;

    public User(){
        this.codigo = -1;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nif = 0;
        this.infoVendas = "";
        this.valorVendas = 0.0;
    }

    public User(int codigo, String email, String nome, String morada, int nif){
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
    }

    public User(int codigo, String email, String nome, String morada, int nif, String[] produtosVendidos, String[] produtosVenda, String[] produtosComprados, String infoVendas, double valorVendas){
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

    public User(User u){
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

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getMorada(){
        return this.morada;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public int getNif(){
        return this.nif;
    }

    public void setNif(int nif){
        this.nif = nif;
    }

    public String[] getProdutosVendidos(){
        return this.produtosVendidos;
    }

    public void setProdutosVendidos(String[] produtosVendidos){
        this.produtosVendidos = produtosVendidos;
    }

    public String[] getProdutosVenda(){
        return this.produtosVenda;
    }

    public void setProdutosVenda(String[] produtosVenda){
        this.produtosVenda = produtosVenda;
    }

    public String[] getProdutosComprados(){
        return this.produtosComprados;
    }

    public void setProdutosComprados(String[] produtosComprados){
        this.produtosComprados = produtosComprados;
    }

    public String getInfoVendas(){
        return this.infoVendas;
    }

    public void setInfoVendas(String infoVendas){
        this.infoVendas = infoVendas;
    }

    public double getValorVendas(){
        return this.valorVendas;
    }

    public void setValorVendas(double valorVendas){
        this.valorVendas = valorVendas;
    }

    @Override
    public String toString() {
        return "{Codigo=" + codigo +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", nif='" + nif + '\'' +
                ", produtosVendidos=" + Arrays.toString(produtosVendidos) +
                ", produtosVenda=" + Arrays.toString(produtosVenda) +
                ", produtosComprados=" + Arrays.toString(produtosComprados) +
                ", infoVendas='" + infoVendas + '\'' +
                ", valorVendas=" + valorVendas +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return codigo == user.codigo && Double.compare(user.valorVendas, valorVendas) == 0 && Objects.equals(email, user.email) && Objects.equals(nome, user.nome) && Objects.equals(morada, user.morada) && Objects.equals(nif, user.nif) && Arrays.equals(produtosVendidos, user.produtosVendidos) && Arrays.equals(produtosVenda, user.produtosVenda) && Arrays.equals(produtosComprados, user.produtosComprados) && Objects.equals(infoVendas, user.infoVendas);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(codigo, email, nome, morada, nif, infoVendas, valorVendas);
        result = 31 * result + Arrays.hashCode(produtosVendidos);
        result = 31 * result + Arrays.hashCode(produtosVenda);
        result = 31 * result + Arrays.hashCode(produtosComprados);
        return result;
    }

    @Override
    public User clone(){
        return new User(this);
    }
}
