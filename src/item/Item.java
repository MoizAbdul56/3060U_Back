package item;

public class Item{
    public String item_name;
    public String seller;
    public String buyer;
    public int auction_day;
    public double current_bid;

    public Item(String item_name,String seller,String buyer,int auction_day,double current_bid){
        this.item_name = item_name;
        this.seller = seller;
        this.buyer = buyer;
        this.auction_day = auction_day;
        this.current_bid = current_bid;
    }

}
