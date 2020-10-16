package SuperMarketP;

import org.junit.Test;

import static org.junit.Assert.*;

public class BVA {
    int CustomerBalance = 1000;
    int mnId = 0;
    int mxId = 99;
    int avgId = 49;
    int mnQty = 1;
    int avgQty = 25;
    int mxQty = 50;
    int id = 50;

    SuperMarket superMarket = new SuperMarket(CustomerBalance);

    public BVA() throws Exception {
    }

    // ID check
    @Test
    public void invalidIdCheck0() {
        assertEquals(false, superMarket.checkExistPdt(mnId - 1));
    }

    @Test
    public void validIdCheck0() {
        assertEquals(true, superMarket.checkExistPdt(mnId));
    }

    @Test
    public void validIdCheck1() {
        assertEquals(true, superMarket.checkExistPdt(mnId + 1));
    }

    @Test
    public void validIdCheck2() {
        assertEquals(true, superMarket.checkExistPdt(avgId));
    }

    @Test
    public void validIdCheck3() {
        assertEquals(true, superMarket.checkExistPdt(mxId - 1));
    }

    @Test
    public void validIdCheck4() {
        assertEquals(true, superMarket.checkExistPdt(mxId));
    }

    @Test
    public void invalidIdCheck1() {
        assertEquals(false, superMarket.checkExistPdt(mxId + 1));
    }

    // Quantity check
    @Test
    public void invalidQtyCheck0() {
        assertEquals(false, superMarket.checkExistQty(id, mnQty - 1));
    }

    @Test
    public void validQtyCheck0() {
        assertEquals(true, superMarket.checkExistQty(id, mnQty));
    }

    @Test
    public void validQtyCheck1() {
        assertEquals(true, superMarket.checkExistQty(id, mnQty + 1));
    }

    @Test
    public void validQtyCheck2() {
        assertEquals(true, superMarket.checkExistQty(id, avgQty));
    }

    @Test
    public void validQtyCheck3() {
        assertEquals(true, superMarket.checkExistQty(id, mxQty - 1));
    }

    @Test
    public void validQtyCheck4() {
        assertEquals(true, superMarket.checkExistQty(id, mxQty));
    }

    @Test
    public void invalidQtyCheck1() {
        assertEquals(false, superMarket.checkExistQty(id, mxQty + 1));
    }

    // Buy/Customer Balance Check
    @Test
    public void invalidCustomerBalance() {
        try {
            superMarket.CustomerBalance = 0;
            superMarket.buy(id, 10);
        } catch (Exception e) {
            assertSame("Sufficient Balance not Available", e.getMessage());
        }
    }

    @Test
    public void validCustomerBalance() throws Exception {
        try {
            superMarket.CustomerBalance = 1000;
            superMarket.buy(id, 10);
        } catch (Exception e) {
            throw new Exception("Wrong TC");
        }
    }
}