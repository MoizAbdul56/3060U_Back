// Description: This class represents the items that are being sold and bought within the system
// Contains a function that constructs the item object and a function that converts all of the items attributes into a string
// Inputs: the item's name, the seller of the item, the buyer of the item, the item's price, the day the item is put up for auction, the item's current bid

package item;

import java.text.DecimalFormat;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Item{
    public String item_name;
    public String seller;
    public String buyer;
    public int auction_day;
    public double current_bid;
    private DecimalFormat df1 = new DecimalFormat("000");
    private DecimalFormat df2 = new DecimalFormat("000.00");

    // Item constructor
    public Item(String item_name,String seller,String buyer,int auction_day,double current_bid){
        this.item_name = item_name;
        this.seller = seller;
        this.buyer = buyer;
        this.auction_day = auction_day;
        this.current_bid = current_bid;
    }

    // Converts the item attributes to string variables
    public String toString(){
        String padded_item_name = String.format("%1$-19s", item_name);
        String padded_seller = String.format("%1$-15s", seller);
        String padded_buyer = String.format("%1$-15s", buyer);
        String padded_day = String.format("%1$3s", df1.format(auction_day));
        String padded_bid = String.format("%1$6s", df2.format(current_bid));

        StringBuilder output = new StringBuilder("");
        output.append(padded_item_name + " " + padded_seller + " " + padded_buyer + " " + padded_day + " " + padded_bid);

        return output.toString();
    }

    @Test
    public void testToString() {
        Item i = new Item("ball", "Alfonso", "Shawn", 1, 13);
        assertEquals("ball Alfanso Shawn 1 13", i.toString());
    }
}
