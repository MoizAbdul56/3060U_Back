// Description: This class processes changes to an account
// Contains functions that saves the addition of an account, deletion of an account, adding credit and refunding credit
// Inputs: user data which includes users username, the users type and the amount of credit the user has

package process;

import java.util.*;
import user.User;

public class ProcessAccount{
    public Map<String, User> users = new HashMap<>();

    public ProcessAccount(){}

    public ProcessAccount(Map<String, User> users){
        this.users = users;
    }

    public void addAccount(String transaction){
        String username = transaction.split(" ")[1];
        String user_type = transaction.split(" ")[2];
        Double credit = new Double(transaction.split(" ")[3]);
        User new_user = new User(username,user_type,credit);

        users.put(username, new_user);
    }

    public void deleteAccount(String transaction){
        String username = transaction.split(" ")[1];
        users.remove(username);
    }

    public void addCredit(String transaction){
        String username = transaction.split(" ")[1];
        Double credit = new Double(transaction.split(" ")[3]);
        users.get(username).credit += credit;
    }

    public void refund(String transaction){
        String buyer = transaction.split(" ")[1];
        String seller = transaction.split(" ")[2];
        Double credit = new Double(transaction.split(" ")[3]);

        users.get(buyer).credit += credit;
        users.get(seller).credit -= credit;

    }
}
