package Users;

import Vintage.Users.User;
import Vintage.Users.Users;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {

    @Test
    public void testSetUsers(){
        Users map = new Users();
        Users users = new Users();
        User user1 = new User();
        users.addUser(user1);
        map.setUsers(users.getUsers());
        assertEquals(map.getUsers(),users.getUsers());
    }
}
