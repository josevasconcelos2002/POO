package Vintage;

import Vintage.Artigos.Artigo;
import Vintage.Artigos.Artigos;
import Vintage.Encomendas.Encomenda;
import Vintage.Encomendas.Encomendas;
import Vintage.Transportadoras.Transportadora;
import Vintage.Transportadoras.Transportadoras;
import Vintage.Users.User;
import Vintage.Users.Users;

import java.io.*;
import java.time.LocalDate;

public class Estado implements Serializable {
    private Users listaDeUtilizadores;
    private Encomendas listaDeEncomendas;  // alterar isto para lista de ENCOMENDAS
    private Artigos listaDeArtigos;
    private Transportadoras listaDeTransportadoras;
    private LocalDate tempoAtual;

    // AQUI VÃO ESTAR AS FUNÇÕES SOBRE OS LOGS E FICHEIROS E ESTADO DO PROGRAMA... GUARDAR OS USERS, CRIAR ARTIGOS, ETC.

    public Estado(){
        this.listaDeUtilizadores = new Users();
        this.listaDeEncomendas = new Encomendas();
        this.listaDeArtigos = new Artigos();
        this.listaDeTransportadoras = new Transportadoras();
        this.tempoAtual = LocalDate.now();
    }

    public Estado(Estado es) {
        this.listaDeUtilizadores = es.listaDeUtilizadores;
        this.listaDeEncomendas = es.listaDeEncomendas;
        this.listaDeArtigos = es.listaDeArtigos;
        this.listaDeTransportadoras = es.listaDeTransportadoras;
        this.tempoAtual = es.tempoAtual;
    }

    public Users getListaDeUtilizadores(){
        return this.listaDeUtilizadores;
    }

    public Encomendas getListaDeEncomendas(){
        return this.listaDeEncomendas;
    }

    public Artigos getListaDeArtigos(){
        return this.listaDeArtigos;
    }

    public Transportadoras getListaDeTransportadoras(){
        return this.listaDeTransportadoras;
    }

    public LocalDate getTempoAtual(){
        return this.tempoAtual;
    }

    public void setListaDeUtilizadores(Users u){
        this.listaDeUtilizadores = u;
    }

    public void setListaDeEncomendas(Encomendas e){    // alterar isto para lista de Encomendas
        this.listaDeEncomendas = e;
    }

    public void setListaDeArtigos(Artigos a){
        this.listaDeArtigos = a;
    }

    public void setListaDeTransportadoras(Transportadoras t){
        this.listaDeTransportadoras = t;
    }

    public void setTempoAtual(LocalDate time){
        this.tempoAtual = time;
    }

    // ENCOMENDAS
    public void addEncomenda(Encomenda e){
        listaDeEncomendas.addEncomenda(e);
    }

    public void removeEncomenda(Encomenda e){
        listaDeEncomendas.removeEncomenda(e);
    }

    public String printEncomendas(){
        return this.listaDeEncomendas.printEncomendas();
    }


    // TRANSPORTADORAS
    public void addTransportadora(Transportadora t){
        listaDeTransportadoras.addTransportadora(t);
    }

    public void removeTransportadora(Transportadora t){
        listaDeTransportadoras.removeTransportadora(t);
    }

    public String printTransportadoras(){
        return this.listaDeTransportadoras.printTransportadoras();
    }

    public boolean existeTransportadoraNome(String nome){
        return listaDeTransportadoras.existeTransportadoraNome(nome);
    }

    // USER(s)
    public int getNewUserCode(){
        return listaDeUtilizadores.sizeUsers() + 1;
    }

    public void addUser(User u){
        listaDeUtilizadores.addUser(u);
    }

    public boolean existeEmail(String email){
        return listaDeUtilizadores.existeEmail(email);
    }

    public void addProdutoComprado(Artigo artigo, String email){
        listaDeUtilizadores.getUserByEmail(email).addProdutoComprado(artigo);
    }

    public void addProdutoVenda(Artigo artigo, String email){
        listaDeUtilizadores.getUserByEmail(email).addProdutoVenda(artigo);
    }

    public void addProdutoVendido(Artigo artigo, String email){
        listaDeUtilizadores.getUserByEmail(email).addProdutoVendido(artigo);
    }

    public void removeProdutoComprado(Artigo artigo, String email){
        listaDeUtilizadores.getUserByEmail(email).removeProdutoComprado(artigo);
    }

    public void removeProdutoVenda(Artigo artigo, String email){
        listaDeUtilizadores.getUserByEmail(email).removeProdutoVenda(artigo);
    }

    public void removeProdutoVendido(Artigo artigo, String email){
        listaDeUtilizadores.getUserByEmail(email).removeProdutoVendido(artigo);
    }

    public String printProdutosComprados(String email){
        String resultado;
        try{
            resultado = listaDeUtilizadores.getUserByEmail(email).stringProdutosComprados();
        }
        catch(java.lang.NullPointerException e){
            resultado = "A lista está vazia!\n";
        }
        return resultado;
    }

    public String printProdutosVendidos(String email){
        String resultado;
        try{
            resultado = listaDeUtilizadores.getUserByEmail(email).stringProdutosVendidos();
        }
        catch(java.lang.NullPointerException e){
            resultado = "A lista está vazia!\n";
        }
        return resultado;
    }

    public String printProdutosVenda(String email){
        String resultado;
        try{
            resultado = listaDeUtilizadores.getUserByEmail(email).stringProdutosVenda();
        }
        catch(java.lang.NullPointerException e){
            resultado = "A lista está vazia!\n";
        }
        return resultado;
    }

    public String printAllUsers(){
        return listaDeUtilizadores.stringUsers();
    }
    public String produtosVendaUsers(){
        return listaDeUtilizadores.produtosVendaUsers();
    }
    public String getUserNameByKey(String email){
        return listaDeUtilizadores.getUserNameByKey(email);
    }

    public User getUserByEmail(String email){
        return this.listaDeUtilizadores.getUserByEmail(email);
    }

    public void addUser(String email){
        this.listaDeUtilizadores.addUser(getUserByEmail(email));
    }




    // ARTIGO(s)
    public String printAllArtigos(){
        return listaDeArtigos.toString();
    }



    // LOGS
    public void escreverLog(String s) {
        try {
            File file = new File("logs/logs.txt");

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(s);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever a string no arquivo.");
            e.printStackTrace();
        }
    }


    // GUARDAR
    public void guardarEstado(String nomeFicheiro) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public void carregaEstado(String nomeFicheiro) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(nomeFicheiro);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Estado estado = (Estado) in.readObject();
        in.close();
        fileIn.close();

        this.listaDeUtilizadores = estado.listaDeUtilizadores;
        this.listaDeEncomendas = estado.listaDeEncomendas;
        this.listaDeArtigos = estado.listaDeArtigos;
        this.listaDeTransportadoras = estado.listaDeTransportadoras;
        this.tempoAtual = estado.tempoAtual;
    }

}