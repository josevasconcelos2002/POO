package Vintage.Artigos;
import java.util.HashMap;
import java.util.Map;

public class Artigos {
    private Map<String, Artigo> listaDeArtigos;

    public Artigos(){
        this.listaDeArtigos = new HashMap<String,Artigo>();
    }

    public Artigos(Map<String,Artigo> listaDeArtigos){
        this.listaDeArtigos = new HashMap<>(listaDeArtigos);
    }

}
