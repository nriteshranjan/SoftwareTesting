package SuperMarketP;

import java.util.HashMap;

public class SuperMarket {

    public int getRandomNumber(int mn, int mx) throws Exception {
        int res = (int) ((Math.random() * (mx - mn)) + mn);
        if (res > mx || res < mn) throw new Exception("Out of range");
        return res;
    }

    /*** Item denotes details of the available item in Supermarket ***/
    public static class Item {
        int stock;
        int price;

        public Item(int stock, int price) {
            this.stock = stock;
            this.price = price;
        }
    }

    /*** Creating Variables ***/
    public int CustomerBalance, noOfItems = 100, initialStock = 50;
    HashMap<Integer, Item> productList = new HashMap<>();

    /*** Constructor ***/
    public SuperMarket(int CustomerBalance) throws Exception {
        this.CustomerBalance = CustomerBalance;

        // To initialise the SuperMarket with 'count' no. of items
        for (int i = 0; i < noOfItems; ++i)
            productList.put(i, new Item(initialStock, getRandomNumber(1, 100)));
    }

    /*** Checking if product exists ***/
    public Boolean checkExistPdt(int id) {
        return productList.containsKey(id);
    }

    /*** Checking for valid quantity ***/
    public Boolean checkExistQty(int id, int quantity) {
        if (quantity <= 0)
            return false;
        return quantity <= productList.get(id).stock;
    }

    /*** Buying item with a particular id ***/
    public int buy(int id, int quantity) throws Exception {
        if (!checkExistPdt(id)) throw new Exception("Item not present");
        if (!checkExistQty(id, quantity))
            throw new Exception("Invalid Quantity Input or Item quantity exceeds available stock");
        if (productList.get(id).price * quantity >= productList.get(id).price) {
            if (productList.get(id).price * quantity > CustomerBalance) // BVA
                throw new Exception("Sufficient Balance not Available");
            else {
                if (productList.get(id).price * quantity >= productList.get(id).price) {
                    CustomerBalance -= (productList.get(id).price * quantity);
                    int initialStock = productList.get(id).stock;
                    productList.get(id).stock -= quantity;
                    if (initialStock <= productList.get(id).stock)
                        throw new Exception("Stock Error Occurred");
                } else throw new Exception("Error Occurred");
            }
        } else throw new Exception("Error Occurred");
        return CustomerBalance;
    }
}