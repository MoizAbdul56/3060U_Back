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

    Writer(Map<String, User> users){
        this.users = users;
    }
    Writer(List<Item> items){
        this.items = items;
    }

    void writerUsers(){

    }

    void writerItems(){

    }
}
