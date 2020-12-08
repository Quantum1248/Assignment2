////////////////////////////////////////////////////////////////////
// [De Franceschi] [Manuel] [1162299]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

public class TakeAwayBillImpl implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) 
    throws RestaurantBillException {
        if (itemsOrdered == null) {
            throw new IllegalArgumentException("ItemsOrder is null");
        }
        if (itemsOrdered.size() == 0) {
            throw new IllegalArgumentException("ItemsOrder is empty");
        }
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }
        if (itemsOrdered.size() > 30) {
            System.out.println("Can't order more than 30 items");
            throw new RestaurantBillException();
        }

        int iceCreamNumber = 0;
        double minIceCreamPrice = Double.MAX_VALUE;
        double result = 0;
        for (MenuItem m : itemsOrdered) {
            result += m.getPrice();
            if (m.getItemType() == MenuItem.ItemType.GELATO) {
                iceCreamNumber++;
                if (m.getPrice() < minIceCreamPrice) {
                    minIceCreamPrice = m.getPrice();
                }
            }
        }

        if (result > 50) {
            result *= 0.9;
        } else if (result < 10) {
            result += 0.5;
        }

        if (iceCreamNumber > 5) {
            result = result - minIceCreamPrice / 2;
        }
        return result;
    }
}
