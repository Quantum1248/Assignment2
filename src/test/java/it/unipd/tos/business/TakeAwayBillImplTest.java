////////////////////////////////////////////////////////////////////
// [De Franceschi] [Manuel] [1162299]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;

import javax.swing.text.IconView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TakeAwayBillImplTest {

    private MenuItem iceCream;
    private MenuItem pudding;
    private MenuItem drink;
    private TakeAwayBillImpl takeAwayBill;
    private User user;

    @BeforeEach
    public void Setup() {
        iceCream = new MenuItem(MenuItem.ItemType.GELATO, "Pinguino", 2D);
        pudding = new MenuItem(MenuItem.ItemType.BUDINO, "Budino", 1D);
        drink = new MenuItem(MenuItem.ItemType.BEVANDA, "Bibita", 0.5D);
        takeAwayBill = new TakeAwayBillImpl();
        user = new User(0, "Nome", "Cognome", 10);
    }

    @Test
    public void testGetOrderPrice() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        orders.add(iceCream);
        orders.add(drink);

        assertEquals(takeAwayBill.getOrderPrice(orders, user), iceCream.getPrice() + drink.getPrice());
    }

    @Test
    public void testGetOrderPriceNullList() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> takeAwayBill.getOrderPrice(null, user));
    }

    @Test
    public void testGetOrderPriceEmptyList() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> takeAwayBill.getOrderPrice(orders, user));
    }

    @Test
    public void testGetOrderPriceNullUser() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        orders.add(iceCream);
        orders.add(drink);
        assertThrows(IllegalArgumentException.class, () -> takeAwayBill.getOrderPrice(orders, null));
    }
}
