import util.Reader;
import util.Writer;
import java.util.*;
import user.User;
import item.Item;
//import process.ProcessAccount;

class main{
    public static void main(String[] args) {
        Reader r = new Reader("transactions.txt");
        for (String transaction:r.data){
            process(transaction);
         }

        // Reader r = new Reader();
        // r.readUser("userAccounts.txt");
        // for (Map.Entry<String,User> entry : r.users.entrySet())
        // System.out.println("Key = " + entry.getKey() +
        //              ", Value = " + entry.getValue().credit);
           //return hashmap of user

           // Reader r = new Reader();
           // r.readUser("userAccounts.txt");
           // for (Map.Entry<String,User> entry : r.users.entrySet())
           // System.out.println("Key = " + entry.getKey() +
           //              ", Value = " + entry.getValue().credit);

        // Reader r = new Reader();
        // r.readItem("items.txt");
        // for (Item transaction:r.items){
        //     System.out.println(transaction.current_bid);
        //  } //return list<item>
    }

    static void process(String transaction){
        String substr = transaction.substring(0,2);
        int index = 0;
        String[] transactions = {"01","02","03","04","05","06","00"};

        for(int i = 0; i < 7; i++){
            index += 1;
            if(substr.equals(transactions[i])){
                break;
            }
        }

        switch(index){
            case 1:
                System.out.println("create");
                //
                //add to Account file
                //
                break;

            case 2:
                System.out.println("delete");
                //
                //delete from Account file function here
                //
                break;

            case 3:
                System.out.println("advertise");
                //
                //advertise function here
                //
                break;

            case 4:
                System.out.println("bid");
                //
                //bid  function here
                //
                break;

            case 5:
                System.out.println("refund");
                //
                //refund function here
                //
                break;

            case 6:
                System.out.println("addcredit");
                //
                //addcredit function here
                //
                break;

            case 7:
                System.out.println("end");
                break;

            default:
                System.out.println("error");
        }
    }
}
