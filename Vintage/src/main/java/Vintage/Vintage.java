package Vintage;

import Vintage.Artigos.Artigo;
import Vintage.Users.User;

import java.io.*;

public class Vintage implements Serializable {
    private User user;
    private Estado estado;

    public Vintage(){
        this.estado = new Estado();
        this.user = null;
    }

    public int newUserCode(){
        return estado.getNewUserCode();
    }

    public void addUser(User u){
        if(!estado.existeEmail(u.getEmail())){
            estado.addUser(u);
            System.out.println("--User adicionado com successo!--");
            Menu.pressToContinue();
        } else {
            Menu.limpaTerminal();
            Menu.errors(1);
        }
    }

    public String getUserNameByKey(String email){
        return this.estado.getUserNameByKey(email);
    }

    public User getUserByEmail(String email){
        return this.estado.getUserByEmail(email);
    }

    public void addUser(String email){
        this.estado.addUser(getUserByEmail(email));
    }

    public String printAllUsers(){
        return estado.printAllUsers();
    }

    public void addProdutoComprado(Artigo artigo, String email){
        estado.getUserByEmail(email).addProdutoComprado(artigo);
    }

    public void addProdutoVenda(Artigo artigo, String email){
        estado.getUserByEmail(email).addProdutoVenda(artigo);
    }

    public void addProdutoVendido(Artigo artigo, String email){
        estado.getUserByEmail(email).addProdutoVendido(artigo);
    }

    public void removeProdutoComprado(Artigo artigo, String email){
        estado.getUserByEmail(email).removeProdutoComprado(artigo);
    }

    public void removeProdutoVenda(Artigo artigo, String email){
        estado.getUserByEmail(email).removeProdutoVenda(artigo);
    }

    public void removeProdutoVendido(Artigo artigo, String email){
        estado.getUserByEmail(email).removeProdutoVendido(artigo);
    }

    public String printProdutosUser(String email){
        String resultado = "Lista de produtos vazia\n";
        try {
            resultado = estado.getUserByEmail(email).toString();
        }
        catch(java.lang.NullPointerException e){
            resultado = "A lista está vazia!\n";
        }
        return resultado;
    }

    public String printProdutosComprados(String email){
        return estado.printProdutosComprados(email);
    }

    public String printProdutosVendidos(String email){
        return estado.printProdutosVendidos(email);
    }

    public String printProdutosVenda(String email){
        return estado.printProdutosVenda(email);
    }

    public String produtosVendaUsers(){
        return estado.produtosVendaUsers();
    }

    /*public void mostrarLogs() {
        estado.loadEstadoLogs();
    }*/

    public void guardaEstado(String saveName) throws IOException {
        this.estado.guardarEstado(saveName);
    }

    public void carregaEstado(String loadName) throws IOException, ClassNotFoundException {
        this.estado.carregaEstado(loadName);
    }

    public boolean login(String email){
        if(this.estado.existeEmail(email)){
            this.user = this.estado.getUserByEmail(email);
            return true;
        } else {
            return false;
        }
    }

    public void logout(){
        this.user = null;
    }

    public void adicionaArtigoParaVenda(){

    }

    public String printAllArtigos(){
        return estado.printAllArtigos();
    }
}
