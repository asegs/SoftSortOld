package manager;
import java.util.ArrayList;
import java.util.Scanner;
import general.*;

public class newProduct {
    static Scanner scanner=new Scanner(System.in);
//    public int home(){
//        return giveValidEntry(0,4,"Would you like to: choose/edit an item category (0), create a new item category (1), list item categories (2), access settings (3), or exit the system (4):");
//    }
//    public String chooseItemCat(){
//
//        String categories= fileReader.reader("./SoftSort/src/general/categories.txt","\n");
//        String[] list=categories.split("\n",0);
//
//        categories="";
//        for (int i=0;i<list.length;i++){
//            categories+=list[i]+"("+i+")  ";
//        }
//        System.out.println("Choose one of the following categories:\n"+categories);
//        int catChoiceInt=-1;
//        while (catChoiceInt<0||catChoiceInt>=list.length){
//            catChoiceInt=scanner.nextInt();
//        }
//        return list[catChoiceInt];
//    }


    public int giveValidEntry(int lowerBound,int upperBound,String question){
        int mainEntryInt=-1;
        while (true) {
            System.out.println(question);
            mainEntryInt = scanner.nextInt();
            if (mainEntryInt>=lowerBound&&mainEntryInt<=upperBound){
                break;
                    } else{
                System.out.println("Enter a number between "+lowerBound +" and "+upperBound+".");
            }
        }
        return mainEntryInt;
    }

//    public void editSubCat(String category){
//        String filename="./SoftSort/src/general/"+category+".txt";
//        String thisCategory=fileReader.reader(filename,"\n");
//        String[] allLines=thisCategory.split("\n");
//        String tempLine="";
//        String subCats="";
//        for (int i=0;i<allLines.length;i++){
//            tempLine=allLines[i];
//            if(tempLine.substring(0,1).equals("+")){
//                subCats+=tempLine.substring(1,tempLine.length())+"\n";
//            }
//        }
//        String[] allSubCats=subCats.split("\n",0);
//        String question="Do you want to edit ";
//        for (int i=0;i<allSubCats.length;i++){
//            question+=allSubCats[i]+"("+i+")  ";
//        }
//        int itemEntryInt=giveValidEntry(0,allSubCats.length-1,question);
//        String subCatChosen=allSubCats[itemEntryInt];
//        int end=thisCategory.indexOf("+",thisCategory.indexOf(subCatChosen));
//        if (end==-1){
//            end=thisCategory.length();
//        }
//        String choppedFile=thisCategory.substring(thisCategory.indexOf(subCatChosen),end);
//        System.out.println(choppedFile);
//        String newOption="";
//        while (true) {
//            int subCatInt = giveValidEntry(0, 3, "Do you want to add an option to a subcategory (0), remove an option (1), add options from a file (2), or quit (3):");
//            if (subCatInt == 0) {
//                Scanner scannerOptions = new Scanner(System.in);
//                System.out.println("Enter the new option:");
//                newOption+="-"+scannerOptions.nextLine()+"\n";
//                String partOne = thisCategory.substring(0, end);
//                String partTwo = thisCategory.substring(end, thisCategory.length());  //Could be bug here due to non-inclusive end
//                String content = partOne + newOption + partTwo;
//                fileEditor.replaceFile(filename, content,false);
//
//            }
//
//
//        }
//
//    }





//    public String giveNewItem(String type, String[] list){
//        String newName=null;
//        boolean inList=true;
//        while (inList){
//            System.out.println("Enter the name of the new "+type+":");
//            newName=scanner.nextLine();
//            inList=false;
//            for (int i=0;i<list.length;i++){
//                if (list[i].equals(newName)){
//                    inList=true;
//                }
//            }
//        }
//        return newName;
//    }





}
