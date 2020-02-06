package manager;
import java.util.ArrayList;
import java.util.Scanner;

public class newProduct {
    public int home(){
        Scanner scanner=new Scanner(System.in);
        int mainEntryInt=4;
        while (true) {
            System.out.println("Would you like to: choose an item category (0), create a new item category (1), list item categories (2), access settings (3), or exit the system (4):");
            String mainEntry = scanner.nextLine();
            if (mainEntry.length() == 1) {
                char mainEntryChar = mainEntry.charAt(0);
                if (Character.isDigit(mainEntryChar)){
                    mainEntryInt=Integer.parseInt(mainEntry);
                    if (mainEntryInt>=0&&mainEntryInt<=4){
                        System.out.println("Ok.");
                        break;
                    }
                }
            }else{
                System.out.println("Enter a number between 0 and 4.");
            }
        }
        return mainEntryInt;
    }
    public void chooseItemCat(){

    }

    public void createItemCat(){

    }

    public void listItemCats(){

    }

    public void settings(){

    }

    public void quit(){

    }



}
