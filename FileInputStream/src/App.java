import java.io.*;

public class App {
    public static void main(String[] args) throws IOException{
        String path = "C:/Users/Joshua/OneDrive/Documents/NewFileHere/Book_Records.txt";
        File file = new File(path);

        Book rRecord = rRecord = new ReadBookDetails(file);
        ((ReadBookDetails) rRecord).read();
        System.out.println("***Book Record***");
        System.out.println(rRecord.toString());
        
    }
}
