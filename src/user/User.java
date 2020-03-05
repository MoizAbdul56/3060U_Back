package user;

public class User{
    public String username;
    public String user_type;
    public double credit;

    public User(String username, String user_type, double credit){
        this.username = username;
        this.user_type = user_type;
        this.credit = credit;
    }

    //toString function that prints the User info as the format of username_____AA_credit
}
