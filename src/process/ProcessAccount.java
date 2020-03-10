package process;

import util.*;
import java.util.*;
import user.User;

public class ProcessAccount{
    public Map<String, User> users = new HashMap<>();

    public ProcessAccount(){}

    public ProcessAccount(Map<String, User> users){
        this.users = users;
    }

    public void addAccount(String transaction){
        String username = transaction.substring(3,18);
        username = username.replaceAll("\\s", "");
        String user_type = transaction.substring(19,21);
        Double credit = new Double(transaction.substring(22,31));
        User new_user = new User(username,user_type,credit);

        users.put(username, new_user);
    }

    public void deleteAccount(String transaction){
        String username = transaction.substring(3,18);
        username = username.replaceAll("\\s", "");
        users.remove(username);
    }

    public void addCredit(String transaction){
        String username = transaction.substring(3,18);
        username = username.replaceAll("\\s", "");
        Double credit = new Double(transaction.substring(22,31));
        users.get(username).credit += credit;
    }

    public void refund(String transaction){
        String buyer = transaction.substring(3,18);
        buyer = buyer.replaceAll("\\s", "");
        String seller = transaction.substring(19,34);
        seller = seller.replaceAll("\\s", "");
        Double credit = new Double(transaction.substring(35,43));

        users.get(buyer).credit += credit;
        users.get(seller).credit -= credit;

    }
}
