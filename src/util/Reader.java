package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import user.User;

public class Reader{
    public List<String> data = new ArrayList<>();
    public Map<String, User> users = new HashMap<>();
    //public List<String> item = new ;

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
                Double credit = new Double(line.substring(19,27));
                User user = new User(username,user_type,credit);
                users.put(username, user);
                System.out.println(line.length());
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    // read item data
    public void readItem(String filename){
        
    }
}
