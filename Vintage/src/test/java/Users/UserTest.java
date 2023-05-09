package Users;

import static org.junit.jupiter.api.Assertions.*;

import Vintage.Users.User;
import org.junit.jupiter.api.Test;
public class UserTest {

    @Test
    public void testSetCodigo(){
        User u = new User();
        u.setCodigo(1);
        assertEquals(1, u.getCodigo());
    }

    @Test
    public void testSetEmail(){
        User u = new User();
        u.setEmail("pedro02@gmail.com");
        assertEquals("pedro02@gmail.com", u.getEmail());
    }

    @Test
    public void testSetNome(){
        User u = new User();
        u.setNome("Pedro");
        assertEquals("Pedro", u.getNome());
    }

    @Test
    public void testSetMorada(){
        User u = new User();
        u.setMorada("---");
        assertEquals("---", u.getMorada());
    }

    @Test
    public void testSetNif(){
        User u = new User();
        u.setNif(264633285);
        assertEquals(264633285, u.getNif());
    }

    @Test
    public void testClone(){
        User u = new User();
        u.setNif(264);
        User clone = u.clone();
        assertEquals(clone.getNif(), u.getNif());
    }

    @Test
    public void testEquals(){
        User u1 = new User();
        u1.setNome("Pedro");
        User u1Clone = u1.clone();
        assertEquals(u1,u1Clone);
    }

}
