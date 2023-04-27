import Vintage.Artigos.Artigos;
import Vintage.Encomendas.Encomendas;
import Vintage.Users.Users;

public class Estado {
    private Users listaDeUtilizadores;
    private Encomendas listaDeEncomendas;
    private Artigos listaDeArtigos;

    public Estado(){
        this.listaDeUtilizadores = new Users();
        this.listaDeEncomendas = new Encomendas();
        this.listaDeArtigos = new Artigos();
    }


    // AQUI VÃO ESTAR AS FUNÇÕES SOBRE OS LOGS E FICHEIROS... GUARDAR OS USERS, ETC.
}
