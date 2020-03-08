package user;
import general.fileReader;
import manager.MapFromFile;
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
            Double pref=scanner.nextDouble();
            WeightMap.put(elem,pref);
            ArrayList<String> options=chosenCat.get(elem);
            if (elem.substring(0,3).equals("<M>")){
                System.out.println("How many "+options.get(2)+" do you want "+name+"."+elem+" to be?  ("+options.get(0)+" to "+options.get(1)+"):");
                int choice = scanner.nextInt();
                while (!(choice<=Integer.parseInt(options.get(1))||choice>=Integer.parseInt(options.get(0)))){
                    System.out.println("That is not within the range.");
                    choice=scanner.nextInt();
                }
                preferencesMap.put(elem,String.valueOf(choice));
            }
            else {
                for (String option : options) {
                    System.out.println("(" + options.indexOf(option) + ")" + option);
                }
                System.out.println("Which of these options do you want for " + name + "." + elem + "?");
                int option;
                boolean hasGone = false;
                while (true) {
                    option = scanner.nextInt();
                    if (option > 0 && option < options.size()) {
                        break;
                    } else {
                        if (hasGone) {
                            System.out.println("This is not a valid option.");
                        }
                        hasGone = true;
                    }
                }
                preferencesMap.put(elem, options.get(option));
            }
        }
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
                if (preference.substring(0,3).equals("<M>")){
                    int choice=Integer.parseInt(preferencesMap.get(preference));
                    int value=Integer.parseInt(items.get(subCounter));
                    double difference=Math.abs(choice-value);
                    ArrayList<String> rangeArr =chosenCat.get(preference);
                    double range=Integer.parseInt(rangeArr.get(1))-Integer.parseInt(rangeArr.get(0));
                    System.out.println(difference/range);
                    object.setScore(WeightMap.get(preference)*(1-difference/range)+object.getScore());
                    //1-difference/range
                }
                else if (preferencesMap.get(preference).equals(items.get(subCounter))){
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
