package user;
import general.fileReader;
import manager.MapFromFile;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class betterPicker {
    static Scanner scanner=new Scanner(System.in);
    public static void choose(){
        HashMap<String,HashMap<String,ArrayList<String>>> map=MapFromFile.makeMap();
        for (String elem:map.keySet()){
            System.out.println("@"+elem);
        }
        System.out.println("Which category would you like to sort?:");
        String name;
        while (true){
            name=scanner.nextLine();
            if (map.keySet().contains(name)){
                break;
            }else{
                System.out.println("That category does not exist.");
            }
        }
        HashMap<String,ArrayList<String >> chosenCat=map.get(name);
        HashMap<String,Double> WeightMap=new HashMap<>();
        HashMap<String,String> preferencesMap=new HashMap<>();
        HashMap<Integer,indivObject> objects=new HashMap<>();
        for (String elem:chosenCat.keySet()){
            System.out.println("How much do you care about "+name+"."+elem+"? (1 is standard, 2 is double, 0.5 is half):");
            Double pref=scanner.nextDouble();;
            WeightMap.put(elem,pref);
            ArrayList<String> options=chosenCat.get(elem);
            for (String option:options){
                System.out.println("-"+option);
            }
            System.out.println("Which of these options do you want for "+name+"."+elem+"?");
            String option;
            while (true){
                option=scanner.nextLine();
                if (options.contains(option)){
                    break;
                }else{
                    System.out.println("This is not a valid option.");
                }
            }
            preferencesMap.put(elem,option);

        }
        String block=fileReader.reader("SoftSort/src/general/"+name+".txt","");
        String[] lst=block.split("\n",0);
        int counter=0;
        for (String item:lst){
            indivObject obj=new indivObject();
            String[] subLst=item.split(",",0);
            for (String subElem:subLst){
                obj.addItems(subElem);
            }
            ArrayList<String> recent=obj.getItems();
            int newCounter=0;
            for (String option:recent){

            }
            objects.put(counter,obj);
            counter++;
        }
    }
}
