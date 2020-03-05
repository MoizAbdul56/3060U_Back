package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader{
    public List<String> data = new ArrayList<>();
    //public List<String> User = new ;
    //public List<String> item = new ;

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

    // public void readerUser(String filename){
    //     try{
    //         BufferedReader reader;
    //         reader = new BufferedReader(new FileReader(filename));
    //         String line = reader.readLine();
    //         while(line != null){
    //             this.data.add(line);
    //             line = reader.readLine();
    //         }
    //         reader.close();
    //     } catch(IOException e){
    //         e.printStackTrace();
    //     }
    // }
    //
    // public void read
}
