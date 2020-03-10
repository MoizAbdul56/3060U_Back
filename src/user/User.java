package user;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class User{
    public String username;
    public String user_type;
    public double credit;
    private DecimalFormat df2 = new DecimalFormat("000000.00");

    public User(){}

    public User(String username, String user_type, double credit){
        this.username = username;
        this.user_type = user_type;
        this.credit = credit;
    }

    //toString function that prints the User info as the format of username_____AA_credit
    public String toString(){
        StringBuilder output = new StringBuilder("");
        String padded_username = String.format("%1$-15s", username);
        String padded_credit = String.format("%1$9s", df2.format(this.credit));
        output.append(padded_username + " " + this.user_type + " " + padded_credit);

        return output.toString();
    }
}
