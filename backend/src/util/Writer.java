// Description: This class writes the attributes of users and items to a file
// Contains functions that get user data, get item data, write user data and write item data
// Inputs: user data, item data and the file being written to

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

    // writes users to file
    public String writerUsers(){
        String userTestString = ""; // For testing puposes

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("../../newUserAccounts.txt"));
            for (Map.Entry<String,User> entry : users.entrySet()){
                writer.write(entry.getValue().toString()+"\n");
                userTestString = userTestString + entry.getValue().toString();
            }
            writer.write("END");
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return userTestString;
    }

    // writes items to file
    public String writerItems(){
        String itemTestString = ""; // For testing puposes

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("../../newItems.txt"));
             for (Map.Entry<Pair<String,String>,Item> entry : items.entrySet()){
                 writer.write(entry.getValue().toString()+"\n");
                 itemTestString = itemTestString + entry.getValue().toString();
             }
            writer.write("END");
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return itemTestString;
    }
}
