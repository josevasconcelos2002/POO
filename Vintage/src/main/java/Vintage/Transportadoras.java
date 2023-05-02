package Vintage;

import Vintage.Users.User;
import Vintage.Users.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Transportadoras {
    private Map<String, User> transportadoras;

    public Transportadoras(){
        this.transportadoras = new HashMap<String,User>();
    }

    public int getNewCode(){
        return 0;
    }

    public Transportadoras(Map<String,Transportadora> transportadoras){
        this.setTransportadoras(transportadoras);
    }

    public Transportadoras(Transportadoras tp){
        this.transportadoras = tp.getTransportadoras();
    }

    public Map<String, User> getTransportadoras() {
        return this.transportadoras.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, HashMap::new));
    }

    public void setTransportadoras(Map<String, Transportadora> transportadoras){
        this.transportadoras = transportadoras.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a,b)->a, HashMap::new));
    }
}
