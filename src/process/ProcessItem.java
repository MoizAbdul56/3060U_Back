package process;

import util.*;
import java.util.*;
import item.Item;
import javafx.util.Pair;

public class ProcessItem{
    public Map<Pair<String, String>, Item> items = new HashMap<>();

    public ProcessItem(Map<Pair<String, String>, Item> items){
        this.items = items;
    }

    public void advertise(String transaction){
        String item_name = transaction.substring(3,22);
        String seller_name = transaction.substring(23,38);
        seller_name = seller_name.replaceAll("\\s", "");
        String buyer_name = "";
        int auction_day = Integer.parseInt(transaction.substring(39,42));
        Double current_bid = new Double(transaction.substring(43,49));

        Pair<String, String> key = new Pair<>(item_name, seller_name);
        Item item = new Item(item_name, seller_name, buyer_name, auction_day, current_bid);
        items.put(key, item);
    }

    public void bid(String transaction){
        String item_name = transaction.substring(3,22);
        item_name = item_name.replaceAll("\\s", "");
        String seller_name = transaction.substring(23,38);
        seller_name = seller_name.replaceAll("\\s", "");
        String buyer_name = transaction.substring(39,54);
        buyer_name = buyer_name.replaceAll("\\s", "");
        Double current_bid = new Double(transaction.substring(55,60));

        Pair<String, String> key = new Pair<>(item_name, seller_name);

        items.get(key).buyer = buyer_name;
        items.get(key).current_bid = current_bid;


    }
}
