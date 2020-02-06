package manager;
import java.util.ArrayList;
import java.util.Scanner;
import general.*;

public class newProduct {
    static Scanner scanner=new Scanner(System.in);
    public int home(){
        int mainEntryInt=4;
        while (true) {
            System.out.println("Would you like to: choose/edit an item category (0), create a new item category (1), list item categories (2), access settings (3), or exit the system (4):");
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
    public String chooseItemCat(){

        String categories= fileReader.reader("./SoftSort/src/general/categories.txt","\n");
        String[] list=categories.split("\n",0);

        categories="";
        for (int i=0;i<list.length;i++){
            categories+=list[i]+"("+i+")  ";
        }
        System.out.println("Choose one of the following categories:\n"+categories);
        int catChoiceInt=-1;
        while (catChoiceInt<0||catChoiceInt>=list.length){
            catChoiceInt=scanner.nextInt();
        }
        return list[catChoiceInt];
    }

    public void editItemCat(){

    }

    public void createItemCat(){
        String categories= fileReader.reader("./SoftSort/src/general/categories.txt","\n");
        String[] list=categories.split("\n",0);
        String newName=null;
        boolean inList=true;
        while (inList){
            System.out.println("Enter the name of the new category:");
            newName=scanner.nextLine();
            inList=false;
            for (int i=0;i<list.length;i++){
                if (list[i].equals(newName)){
                    inList=true;
                }
            }
        }
        fileEditor.addToFile("./SoftSort/src/general/categories.txt",newName);
        fileGenerator.createFile(newName+".txt");
        System.out.println("Category "+newName+" created.");

    }

    public void listItemCats(){

    }

    public void settings(){

    }

    public void quit(){

    }

    public static void main(String[] args) {
        newProduct prod=new newProduct();
        prod.createItemCat();
    }
}
