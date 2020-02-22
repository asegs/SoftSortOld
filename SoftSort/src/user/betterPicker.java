package user;
import general.fileReader;
import manager.MapFromFile;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class betterPicker {
    static Scanner scanner=new Scanner(System.in);
    static double maxScore=0;
    public static Passer choose(){
        HashMap<String,HashMap<String,ArrayList<String>>> map=MapFromFile.makeMap();
        for (String elem:map.keySet()){
            System.out.println("@"+elem);
        }
        System.out.println("Which category would you like to sort?:");
        String name;
        while (true){
            name=scanner.nextLine();
            if (map.containsKey(name)){
                break;
            }else{
                System.out.println("That category does not exist.");
            }
        }
        HashMap<String,ArrayList<String >> chosenCat=map.get(name);
        HashMap<String,Double> WeightMap=new HashMap<>();
        HashMap<String,String> preferencesMap=new HashMap<>();
        ArrayList<indivObject> objects=new ArrayList<>();
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
            boolean hasGone=false;
            while (true){
                option=scanner.nextLine();
                if (options.contains(option)){
                    break;
                }else{
                    if (hasGone){
                        System.out.println("This is not a valid option.");
                    }
                    hasGone=true;
                }
            }
            preferencesMap.put(elem,option);

        } //good
        String block=fileReader.reader("SoftSort/src/general/"+name+".txt","\n");
        String[] lst=block.split("\n",0);
        int counter=0;
        for (String item:lst){
            indivObject obj=new indivObject();
            String[] subLst=item.split(",",0);
            for (String subElem:subLst){
                obj.addItems(subElem);
            }
            objects.add(obj);
            counter++;
        }

        for (int i=0;i<counter;i++){
            indivObject object=objects.get(i);
            ArrayList<String> items=object.getItems();
            int subCounter=0;
            for (String preference:preferencesMap.keySet()){
                if (preferencesMap.get(preference).equals(items.get(subCounter))){
                    object.setScore(WeightMap.get(preference)+object.getScore());
                }
                subCounter++;
            }
            objects.set(i,object);
        }
        for (String elem:WeightMap.keySet()){
            maxScore+=WeightMap.get(elem);
        }
        Collections.sort(objects);
        Passer passer=new Passer(objects.get(0),maxScore);
        return passer;
    }
}
