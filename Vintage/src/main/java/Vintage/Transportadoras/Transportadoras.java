package Vintage.Transportadoras;

import Vintage.Users.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Transportadoras implements Serializable {
    private Map<String, Transportadora> transportadoras;

    public Transportadoras(){
        this.transportadoras = new HashMap<String,Transportadora>();
    }

    public Transportadoras(Map<String, Transportadora> transportadoras){
        this.setTransportadoras(transportadoras);
    }

    public Transportadoras(Transportadoras tp){
        this.transportadoras = tp.getTransportadoras();
    }

    public Map<String, Transportadora> getTransportadoras() {
        return this.transportadoras.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new));
    }

    public void setTransportadoras(Map<String, Transportadora> transportadoras){
        this.transportadoras = transportadoras.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a, b)->a, HashMap::new));
    }

    public void addTransportadora(Transportadora t){
        this.transportadoras.put(t.getNome(),t.clone());
    }

    public void removeTransportadora(Transportadora t){
        this.transportadoras.remove(t.getNome());
    }

    public boolean existeTransportadoraNome(String nome){
        return this.transportadoras.containsKey(nome);
    }

    public Transportadora getTransportadoraByName(String nome){
        if (existeTransportadoraNome(nome))
            return this.transportadoras.get(nome).clone();  //IMPORTANTE!!! USAR .clone() ou não!
        return null;
    }
    public String printTransportadoras(){
        StringBuilder sb = new StringBuilder();
        sb.append("Transportadoras: \n\n");
        for (Transportadora t : transportadoras.values()) {
            sb.append("\t").append(t.stringTransportadora()).append("\n");
        }
        return sb.toString();
    }

    public int sizeTransportadoras(){
        return transportadoras.size();
    }
}
