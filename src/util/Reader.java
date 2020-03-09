package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import user.User;
import item.Item;

public class Reader{
    public List<String> data = new ArrayList<>();
    public Map<String, User> users = new HashMap<>();
    public List<Item> items = new ArrayList<>();

    public Reader(){}
    //read general data
    public Reader(String filename){
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null){
                this.data.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    //read user data and put them into a hashmap
    public void readUser(String filename){
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null){
                if(line.equals("END")){
                    break;
                }
                String username = line.substring(0,15);
                String user_type = line.substring(16,18);
                Double credit = new Double(line.substring(19,28));
                User user = new User(username,user_type,credit);
                users.put(username, user);
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    // read item data
    public void readItem(String filename){
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null){
                if(line.equals("END")){
                    break;
                }
                String item_name = line.substring(0,19);
                String seller = line.substring(20,35);
                String buyer = line.substring(36,51);
                int auction_day = 1;// Integer.parseInt(line.substring(52,55));
                Double current_bid = new Double(line.substring(56,62));
                Item item = new Item(item_name,seller,buyer,auction_day,current_bid);
                this.items.add(item);
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
