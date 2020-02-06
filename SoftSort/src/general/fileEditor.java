package general;

import java.io.FileWriter;
import java.io.IOException;

public class fileEditor {
    fileReader fReader=new fileReader();
    public static void addToFile(String filename, String content){
        try {
            FileWriter myWriter = new FileWriter(filename);
                String old=fileReader.reader(filename,"");
                myWriter.write(old);
                myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    }
