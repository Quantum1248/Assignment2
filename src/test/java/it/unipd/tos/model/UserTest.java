////////////////////////////////////////////////////////////////////
// [De Franceschi] [Manuel] [1162299]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import org.junit.jupiter.api.*;

import it.unipd.tos.model.User;

public class UserTest {
    @Test
    public void testConstructorSuccess() {
        User user = new User(0, "Nome", "Cognome", 10);
        Assertions.assertEquals(user.getId(), 0);
        Assertions.assertEquals(user.getName(), "Nome");
        Assertions.assertEquals(user.getSurname(), "Cognome");
        Assertions.assertEquals(user.getAge(), 10);
    }

    @Test
    public void testConstructorEmptyName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(0, "", "Cognome", 10));
    }

    @Test
    public void testConstructorNullName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(0, null, "Cognome", 10));
    }

    @Test
    public void testConstructorEmptySurname() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(0, "Nome", "", 10));
    }

    @Test
    public void testConstructorNullSurname() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(0, "Nome", null, 10));
    }

    @Test
    public void testConstructorNegativeAge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(0, "Nome", "Cognome", -1));
    }

    @Test
    public void testGetId() {
        User user = new User(0, "Nome", "Cognome", 10);
        Assertions.assertEquals(user.getId(), 0);
    }

    @Test
    public void testGetName() {
        User user = new User(0, "Nome", "Cognome", 10);
        Assertions.assertEquals(user.getName(), "Nome");
    }

    @Test
    public void testGetSurname() {
        User user = new User(0, "Nome", "Cognome", 10);
        Assertions.assertEquals(user.getSurname(), "Cognome");
    }

    @Test
    public void testGetAge() {
        User user = new User(0, "Nome", "Cognome", 10);
        Assertions.assertEquals(user.getAge(), 10);
    }
}
