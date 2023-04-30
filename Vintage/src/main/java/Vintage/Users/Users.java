package Vintage.Users;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
<<<<<<< HEAD
//import java.util.Set;
=======
import java.util.stream.Collectors;
>>>>>>> refs/remotes/origin/main

public class Users implements Serializable {
    private Map<String, User> users;

    public Users(){
        this.users = new HashMap<String,User>();
    }

<<<<<<< HEAD
    public static int getNewCode(){
        return 0;
=======
    public Users(Map<String,User> Users){
        this.setUsers(Users);
>>>>>>> refs/remotes/origin/main
    }

    public Users(Users us){
        this.users = us.getUsers();
    }

    public Map<String, User> getUsers() {
        return this.users.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, HashMap::new));
    }

    public void setUsers(Map<String, User> users){
        this.users = users.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a,b)->a, HashMap::new));
    }

    public void addUser(User us){
        this.users.put(us.getEmail(), us.clone());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contas {\n");
        for (User user : users.values()) {
            sb.append("\t").append(user.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public Users clone(){
        return new Users(this);
    }

    public User getUserByEmail(String email){
        if (this.users.containsKey(email))
            return this.users.get(email).clone();
        return null;
    }

    public User getUserByCode(int code){
        User conta = this.users.values().stream()
                .reduce(null, (acc, x) -> (x.getCodigo() == code) ? x : acc);
        if(conta != null) return conta.clone();
        else return null;
    }

    public boolean existeEmail(String email){
        return this.users.containsKey(email);
    }

    public int size(){
        return users.size();
    }

}
