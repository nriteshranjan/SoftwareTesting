package SuperMarketP;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test0 {
    int CustomerBalance = 1000;
    SuperMarket superMarket = new SuperMarket(CustomerBalance);

    @Test
    public void initialise() {
        assertEquals(1000, superMarket.CustomerBalance);
    }

    @Test
    public void checkExist() {
        assertEquals(true, superMarket.checkExistPdt(0));
        assertEquals(true, superMarket.checkExistPdt(9));
        assertEquals(false, superMarket.checkExistPdt(1001));
        assertEquals(false, superMarket.checkExistPdt(190));
    }

    @Test
    public void buyValidId() throws Exception {
        // check remaining BALANCE
        int id = 5;
        int quantity = 1;
        if(!superMarket.checkExistPdt(id)) throw new Exception("Item not present");
        int Price = superMarket.productList.get(id).price;
        int totalCost = Price * quantity;
        assertEquals(superMarket.CustomerBalance - totalCost, superMarket.buy(id, quantity));
    }

    @Test
    public void buyInvalid() {
        try {
            // check remaining BALANCE
            int id = 10;
            int quantity = 1;
            if(!superMarket.checkExistPdt(id)) throw new Exception("Item not present");
            int Price = superMarket.productList.get(id).price;
            int totalCost = Price * quantity;
            assertEquals(superMarket.CustomerBalance - totalCost, superMarket.buy(id, quantity));
        }
        catch(Exception e) {
            assertEquals("Item not present", e.getMessage());
        }
    }

}