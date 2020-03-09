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
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("                            ");
        output.replace(0,this.username.length(),this.username);
        output.replace(16,18, this.user_type);
        output.replace(19,28,String.valueOf(this.credit));

        return output.toString();
    }
}
