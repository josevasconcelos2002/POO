package Vintage.Users;

public class User {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private String nif;
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
        this.nif = "";
        this.infoVendas = "";
        this.valorVendas = 0.0;
    }

    public User(int codigo, String email, String nome, String morada, String nif){
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.nif = nif;
    }

    public User(int codigo, String email, String nome, String morada, String nif, String[] produtosVendidos, String[] produtosVenda, String[] produtosComprados, String infoVendas, double valorVendas){
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

    public String getNif(){
        return this.nif;
    }

    public void setNif(String nif){
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
}
