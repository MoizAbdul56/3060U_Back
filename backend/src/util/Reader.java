// Description: This class reads the attributes of users and items from a file
// Contains functions that read general data, read user data and read item data
// Inputs: general data, user data, item data and the file being read

package util;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javafx.util.Pair;
import org.junit.Test;
import user.User;
import item.Item;

public class Reader{
    public List<String> data = new ArrayList<>();
    public Map<String, User> users = new HashMap<>();
    public Map<Pair<String,String>, Item> items = new HashMap<>();

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
                String username = line.split(" ")[0];
                String user_type = line.split(" ")[1];
                Double credit = new Double(line.split(" ")[2]);
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
                if(line.equals("END")) {
                    break;
                }
                String item_name = line.split(" ")[0];
                String seller = line.split(" ")[1];
                String buyer = line.split(" ")[2];
                int auction_day = Integer.parseInt(line.split(" ")[3]);
                Double current_bid = new Double(line.split(" ")[4]);
                Item item = new Item(item_name,seller,buyer,auction_day,current_bid);
                Pair<String, String> key = new Pair<>(item_name, seller);
                items.put(key, item);
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void readUserTest(){

    }
    public void readItemTest(){

    }

}
