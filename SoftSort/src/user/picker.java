package user;
import general.fileReader;
import manager.MapFromFile;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class picker {
    static Scanner scanner=new Scanner(System.in);
    public static void getInputs(){
        HashMap<String,HashMap<String, ArrayList<String>>> map = MapFromFile.makeMap();
        for (String elem: map.keySet()){
            System.out.println("@"+elem);
        }
        System.out.println("Which category would you like to filter?:");
        String entry;
        while (true) {
            entry=scanner.nextLine();
            if (map.keySet().contains(entry)){ //check if file has been made
                break;
            }else{
                System.out.println("Sorry, that item has not been added yet.");
            }
        }
        HashMap<String,ArrayList<String>> chosenMap=map.get(entry);
        HashMap<String, Double> preferences= new HashMap<>();
        for (String item:chosenMap.keySet()){
            System.out.println("How much do you care about your "+entry+"'s "+item+"? (1 is standard, 2 is double, 0.5 is low):");
            Double score=scanner.nextDouble();
            preferences.put(item,score);
        }
        Double maxScore=0.0;
        HashMap<String,String> choices=new HashMap<>();
        for (String elem:preferences.keySet()){
            ArrayList<String> tempArr=chosenMap.get(elem);
            for (int i=0;i<tempArr.size();i++){
                System.out.println(tempArr.get(i));
            }
            System.out.println("Which option do you prefer?:");
            String tempChoice="";
            while (true){
                tempChoice=scanner.nextLine();
                if(tempArr.contains(tempChoice)){
                    choices.put(elem,tempChoice);
                    break;
                }else{
                    System.out.println("This is not a valid option.");
                }
            }
            maxScore+=preferences.get(elem);

        }
        String datasetCSV= fileReader.reader("SoftSort/src/general/"+entry+".txt","");
        HashMap<Integer,String//>
    }

    public static void main(String[] args) {
        getInputs();
    }
}
