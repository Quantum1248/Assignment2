////////////////////////////////////////////////////////////////////
// [De Franceschi] [Manuel] [1162299]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import org.junit.jupiter.api.*;

import it.unipd.tos.model.MenuItem;

public class MenuItemTest {

    @Test
    public void testConstructorSuccess() {
        MenuItem mi = new MenuItem(MenuItem.ItemType.BEVANDA, "Acqua", 1D);
        Assertions.assertEquals(mi.getItemType(), MenuItem.ItemType.BEVANDA);
        Assertions.assertEquals(mi.getName(), "Acqua");
        Assertions.assertEquals(mi.getPrice(), 1D);
    }

    @Test
    public void testConstructorNullType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MenuItem(null, "Acqua", 1D));
    }

    @Test
    public void testConstructorEmptyName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MenuItem(MenuItem.ItemType.BEVANDA, "", 1D));
    }

    @Test
    public void testConstructorNullName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MenuItem(MenuItem.ItemType.BEVANDA, null, 1D));
    }

    @Test
    public void testConstructorZeroPrice() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MenuItem(MenuItem.ItemType.BEVANDA, "Acqua", 0D));
    }

    @Test
    public void testConstructorNegativePrice() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MenuItem(MenuItem.ItemType.BEVANDA, "Acqua", -1D));
    }

    @Test
    public void testGetItemType() {
        MenuItem mi = new MenuItem(MenuItem.ItemType.BEVANDA, "Acqua", 1D);
        Assertions.assertEquals(mi.getItemType(), MenuItem.ItemType.BEVANDA);
    }

    @Test
    public void testGetName() {
        MenuItem mi = new MenuItem(MenuItem.ItemType.BEVANDA, "Acqua", 1D);
        Assertions.assertEquals(mi.getName(), "Acqua");
    }

    @Test
    public void testGetPrice() {
        MenuItem mi = new MenuItem(MenuItem.ItemType.BEVANDA, "Acqua", 1D);
        Assertions.assertEquals(mi.getPrice(), 1D);
    }

}
