package general;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class fileReader {
    public static String reader(String filename){
        String data="";
        try {
            File myObj = new File(filename);
            System.out.println(myObj);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }


    public static void main(String[] args) {
        System.out.println(reader("./src/general/test.txt"));
    }
}

