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

        double result = 0;
        for (MenuItem m : itemsOrdered) {
            result += m.getPrice();
        }
        return result;
    }

}
