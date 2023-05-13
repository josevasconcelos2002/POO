package Vintage;

import Vintage.Artigos.Artigo;
import Vintage.Transportadoras.Transportadora;
import Vintage.Users.User;

import java.io.*;

public class Vintage implements Serializable {
    private User user;
    private Estado estado;
    private static double baseExpedicaoPequenas = 2.0;
    private static double baseExpedicaoMedias = 1.5;
    private static double baseExpedicaoGrandes = 1.0;
    public static double imposto = 0.23;

    public Vintage(){
        this.estado = new Estado();
        this.user = null;
    }

    public int newUserCode(){
        return estado.getNewUserCode();
    }

    public Estado getEstado(){
        return this.estado;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public void addUser(User u){
        if(!estado.existeEmail(u.getEmail())){
            estado.addUser(u);
            Menu.success(6);
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




    // TRANSPORTADORA(s)
    public void addTransportadora(Transportadora t){
        if(!estado.existeTransportadoraNome(t.getNome())){
            estado.addTransportadora(t);
            Menu.success(5);
            Menu.pressToContinue();
        } else {
            Menu.limpaTerminal();
            Menu.errors(12);
        }
    }

    public void removeTransportadora(Transportadora t){
        estado.removeTransportadora(t);
    }

    public String printTransportadoras(){
        return estado.printTransportadoras();
    }

    public static double getBaseExpedicaoPequenas(){
        return baseExpedicaoPequenas;
    }

    public static double getBaseExpedicaoMedias(){
        return baseExpedicaoMedias;
    }

    public static double getBaseExpedicaoGrandes(){
        return baseExpedicaoGrandes;
    }

    public static double getExpedicaoImposto(){
        return imposto;
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
