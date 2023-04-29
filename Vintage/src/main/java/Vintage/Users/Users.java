package Vintage.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Users {
    private Map<String, User> users;

    public Users(){
        this.users = new HashMap<String,User>();
    }

    public int size(){
        return users.size();
    }
}
