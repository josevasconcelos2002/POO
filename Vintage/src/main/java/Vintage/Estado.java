package Vintage;

import Vintage.Artigos.Artigos;
import Vintage.Encomendas.Encomendas;
import Vintage.Transportadoras.Transportadoras;
import Vintage.Users.User;
import Vintage.Users.Users;

import java.io.*;
import java.time.LocalDate;

public class Estado implements Serializable {
    private Users listaDeUtilizadores;
    private Encomendas listaDeEncomendas;
    private Artigos listaDeArtigos;
    private Transportadoras listaDeTransportadoras;
    private LocalDate tempoAtual;

    // AQUI VÃO ESTAR AS FUNÇÕES SOBRE OS LOGS E FICHEIROS E ESTADO DO PROGRAMA... GUARDAR OS USERS, CRIAR ARTIGOS, ETC.

    public Estado(){
        this.listaDeUtilizadores = new Users();
        this.listaDeEncomendas = new Encomendas();
        this.listaDeArtigos = new Artigos();
    }

    public Estado(Estado es) {
        this.listaDeUtilizadores = es.listaDeUtilizadores;
        this.listaDeEncomendas = es.listaDeEncomendas;
        this.listaDeArtigos = es.listaDeArtigos;
    }

    public int getNewUserCode(){
        return listaDeUtilizadores.size() + 1;
    }

    public void addUser(User u){
        listaDeUtilizadores.addUser(u);
    }

    public boolean existeEmail(String email){
        return listaDeUtilizadores.existeEmail(email);
    }

    public String printAllUsers(){
        return listaDeUtilizadores.toString();
    }

    public String printAllArtigos(){
        return listaDeArtigos.toString();
    }

    public String getUserNameByKey(String email){
        return listaDeUtilizadores.getUserNameByKey(email);
    }

    public User getUserByEmail(String email){
        return this.listaDeUtilizadores.getUserByEmail(email);
    }

    // Função que guarda o estado da aplicação(guarda os objetos)
    public void guardarEstado(String nomeFicheiro) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();

        System.out.println("Estado guardado com sucesso!!");
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


    // escrever em ficheiros
    public static void writeOnFile(String file){
        try{
            File myFile = new File(file);
            if(myFile.createNewFile()){
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }

        }catch (IOException e){
            System.out.println("Nao se consegui escrever num ficheiro");
        }
    }
}
