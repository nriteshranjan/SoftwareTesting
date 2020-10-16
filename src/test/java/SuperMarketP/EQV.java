package SuperMarketP;

import org.junit.Test;

import static org.junit.Assert.*;

public class EQV {
    int CustomerBalance = 1000;
    int mnId = 0;
    int mxId = 99;
    int mnQty = 1;
    int mxQty = 50;
    int id = 50;

    SuperMarket superMarket = new SuperMarket(CustomerBalance);

    public EQV() throws Exception {
    }

    // Invalid check
    @Test
    public void invalidIdCheck0() {
        assertEquals(false, superMarket.checkExistPdt(mnId - 1));
    }

    @Test
    public void invalidIdCheck1() {
        assertEquals(false, superMarket.checkExistPdt(mxId + 1));
    }

    @Test
    public void invalidQtyCheck0() {
        assertEquals(false, superMarket.checkExistQty(id, mnQty - 1));
    }

    @Test
    public void invalidQtyCheck1() {
        assertEquals(false, superMarket.checkExistQty(id, mxQty + 1));
    }

    @Test
    public void invalidCustomerBalance() {
        try {
            superMarket.CustomerBalance = 0;
            superMarket.buy(3, 8);
        } catch (Exception e) {
            assertSame("Sufficient Balance not Available", e.getMessage());
        }
    }

    // Valid check
    @Test
    public void validBuy() throws Exception {
        try {
            superMarket.CustomerBalance = 1000;
            superMarket.buy(id, 10);
        } catch (Exception e) {
            throw new Exception("Wrong TC");
        }
    }
}