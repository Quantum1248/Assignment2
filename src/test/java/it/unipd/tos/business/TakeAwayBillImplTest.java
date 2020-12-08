////////////////////////////////////////////////////////////////////
// [De Franceschi] [Manuel] [1162299]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.business.exception.TakeAwayBillException;
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
    public void testGetOrderPriceWithoutDiscount() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        orders.add(iceCream);
        orders.add(drink);

        assertEquals(takeAwayBill.getOrderPrice(orders, user), iceCream.getPrice() + drink.getPrice());
    }

    @Test
    public void testGetOrderPriceWithOnlyFiveIceCream() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        double price = 0;
        for (int i = 1; i < 6; i++) {
            orders.add(new MenuItem(MenuItem.ItemType.GELATO, "Gelato" + i, i));
            price += i;
        }

        assertEquals(takeAwayBill.getOrderPrice(orders, user), price);
    }

    @Test
    public void testGetOrderPriceWithFiveIceCreamAndOtherThings() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        double price = 0;
        for (int i = 1; i < 6; i++) {
            orders.add(new MenuItem(MenuItem.ItemType.GELATO, "Gelato" + i, i));
            price += i;
        }
        orders.add(pudding);
        price += pudding.getPrice();
        orders.add(drink);
        price += drink.getPrice();

        assertEquals(takeAwayBill.getOrderPrice(orders, user), price);
    }

    @Test
    public void testGetOrderPriceWithSixIceCream() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        double price = 0;
        for (int i = 1; i < 7; i++) {
            orders.add(new MenuItem(MenuItem.ItemType.GELATO, "Gelato" + i, i));
            price += i;
        }
        price -= 0.5;

        assertEquals(takeAwayBill.getOrderPrice(orders, user), price);
    }

    @Test
    public void testGetOrderPriceWithMoreThanSixIceCream() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        double price = 0;
        for (int i = 2; i < 10; i++) {
            orders.add(new MenuItem(MenuItem.ItemType.GELATO, "Gelato" + i, i));
            price += i;
        }
        price -= 1;

        assertEquals(takeAwayBill.getOrderPrice(orders, user), price);
    }

    @Test
    public void testGetOrderPriceEqualsFifty() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        double price = 50;
        orders.add(new MenuItem(MenuItem.ItemType.GELATO, "Gelato", price));

        assertEquals(takeAwayBill.getOrderPrice(orders, user), price);
    }

    @Test
    public void testGetOrderPriceOverFifty() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        double price = 51;
        orders.add(new MenuItem(MenuItem.ItemType.GELATO, "Gelato", price));
        price *= 0.9;
        assertEquals(takeAwayBill.getOrderPrice(orders, user), price);
    }

    @Test
    public void testGetOrderPriceWithThirtyOrder() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        double price = 0;
        for (int i = 1; i < 30; i++) {
            orders.add(new MenuItem(MenuItem.ItemType.BEVANDA, "Drink" + i, 1));
            price += 1;
        }

        assertEquals(takeAwayBill.getOrderPrice(orders, user), price);
    }

    @Test
    public void testGetOrderPriceWithMoreThanThirtyOrder() throws Exception {
        List<MenuItem> orders = new LinkedList<>();
        for (int i = 1; i < 32; i++) {
            orders.add(new MenuItem(MenuItem.ItemType.GELATO, "Gelato" + i, i));
        }

        assertThrows(RestaurantBillException.class, () -> takeAwayBill.getOrderPrice(orders, user));
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
