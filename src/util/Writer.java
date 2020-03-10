package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import user.User;
import item.Item;

public class Writer{
    public Map<String, User> users = new HashMap<>();
    public List<Item> items = new ArrayList<>();

    public Writer(Map<String, User> users){
        this.users = users;
    }
    public Writer(List<Item> items){
        this.items = items;
    }

    public void writerUsers(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("NewUserAccounts.txt"));
            for (Map.Entry<String,User> entry : users.entrySet()){
                writer.write(entry.getValue().toString()+"\n");
            }
            writer.write("END");
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writerItems(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("NewItems.txt"));
            for (Item transaction:items){
                writer.write(transaction.toString());
             }
            writer.write("END");
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
