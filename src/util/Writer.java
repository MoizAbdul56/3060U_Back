package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javafx.util.Pair;
import user.User;
import item.Item;

public class Writer{
    public Map<String, User> users = new HashMap<>();
    public Map<Pair<String,String>, Item> items = new HashMap<>();

    public Writer(){}

    public Writer(Map<String, User> users){
        this.users = users;
    }


    public void getItem(Map<Pair<String,String>, Item> items){
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
             for (Map.Entry<Pair<String,String>,Item> entry : items.entrySet()){
                 writer.write(entry.getValue().toString()+"\n");
             }
            writer.write("END");
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
