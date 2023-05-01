package Vintage.Artigos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Artigos implements Serializable {
    private Map<String, Artigo> listaDeArtigos;

    public Artigos(){
        this.listaDeArtigos = new HashMap<String,Artigo>();
    }

    public Artigos(Map<String, Artigo> listaDeArtigos){
        this.setListaDeArtigos(listaDeArtigos);
    }

    public Artigos(Artigos as){
        this.listaDeArtigos = as.getListaDeArtigos();
    }

    public int getNewCode(){
        return 0;
    }

    public Map<String, Artigo> getListaDeArtigos() {
        return this.listaDeArtigos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, HashMap::new));
    }

    public void setListaDeArtigos(Map<String, Artigo> listaDeArtigos){
        this.listaDeArtigos = listaDeArtigos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a,b)->a, HashMap::new));
    }

}
