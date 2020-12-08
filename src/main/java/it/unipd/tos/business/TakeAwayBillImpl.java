////////////////////////////////////////////////////////////////////
// [De Franceschi] [Manuel] [1162299]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
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

        if (iceCreamNumber > 5) {
            result = result - minIceCreamPrice / 2;
        }

        return result;
    }

}
