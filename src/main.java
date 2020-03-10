import util.Reader;
import util.Writer;
import java.util.*;
import user.User;
import item.Item;
import process.ProcessAccount;
import process.ProcessItem;


class main{
    public static void main(String[] args) {
        Reader r = new Reader("transactions.txt");
        r.readUser("userAccounts.txt");
        r.readItem("items.txt");
        ProcessAccount pa = new ProcessAccount(r.users);
        ProcessItem pi = new ProcessItem(r.items);

        for (String transaction:r.data){
            if(process(transaction, pa, pi) == 0){
                break;
            }
         }

         Writer w = new Writer(pa.users);
         w.getItem(pi.items);

         w.writerUsers();
         w.writerItems();
    }

    static int process(String transaction, ProcessAccount pa, ProcessItem pi){
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
                pa.addAccount(transaction);
                break;

            case 2:
                pa.deleteAccount(transaction);
                break;

            case 3:
                pi.advertise(transaction);
                break;

            case 4:
                pi.bid(transaction);
                break;

            case 5:
                pa.refund(transaction);
                break;

            case 6:
                pa.addCredit(transaction);
                break;

            case 7:
                return 0;

            default:
                System.out.println("error");
                return -1;
        }
        return 1;
    }
}
