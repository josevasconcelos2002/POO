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
}
