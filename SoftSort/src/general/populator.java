package general;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import manager.*;
import java.util.Random;

public class populator{
    static Scanner scanner=new Scanner(System.in);
    static Random random=new Random();
    public static void createData(){
        HashMap<String,HashMap<String,ArrayList<String>>> map=MapFromFile.makeMap();
        for (String elem: map.keySet()){
            System.out.println("@"+elem);
        }
        System.out.println("Which category would you like to populate?");
        String entry="";
        while (true){
            entry=scanner.nextLine();
            if (map.keySet().contains(entry)){
                break;
            }else{
                System.out.println("That entry does not exist.  Would you like to create more categories? (y/n):");
                String choice="";
                while (true){
                    choice=scanner.nextLine();
                    if (choice.equals("y")){
                        useMap.home();
                    }
                    break;
                }
            }
        }
        HashMap<String,ArrayList<String>> chosenMap=map.get(entry);
        System.out.println("How many objects would you like to generate? (1000 to 100000 is reasonable):");
        int numberOfObjs;
        while (true){
            numberOfObjs=scanner.nextInt();
            if (numberOfObjs<=1000000){
                break;
            }
        }
        fileGenerator.createFile(entry+".txt");
        String mainString="";
        String indivString;
        for (int i=0;i<numberOfObjs;i++){
            indivString="";
            for (String item:chosenMap.keySet()){
                ArrayList<String> tempArr=chosenMap.get(item);
                if (item.substring(0,3).equals("<M>")){
                    int randNum=Integer.parseInt(tempArr.get(0))+random.nextInt(Integer.parseInt(tempArr.get(1)));
                    indivString+=randNum+",";
                }
                else {
                    int randNum = random.nextInt(tempArr.size());
                    indivString += tempArr.get(randNum) + ",";
                }
            }
            indivString=indivString.substring(0,indivString.length()-1);
            indivString+="\n";
            mainString+=indivString;
        }
        fileEditor.replaceFile("SoftSort/src/general/"+entry+".txt",mainString,true);
    }

//    public static void main(String[] args) {
//        createData();
//    }
}