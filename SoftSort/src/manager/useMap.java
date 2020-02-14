package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class useMap {
    static public HashMap<String,HashMap<String, ArrayList<String>>> map=MapFromFile.makeMap();
    static public Scanner scanner=new Scanner(System.in);
    static public newProduct prod =new newProduct();
    public void addCat(){
        System.out.println("What will the new category be called?");
        while (true){
            String newCat=scanner.nextLine();
            if (!map.containsKey(newCat)){
                HashMap<String,ArrayList<String>> newMap=new HashMap<>();
                map.put(newCat,newMap);
                FileFromMap.makeFile(map);
                break;
            }else{
                System.out.println("That category already exists.  Would you like to edit it? (y/n):");
                boolean edit=false;
                while (true){
                    String newCatChoice=scanner.nextLine();
                    if (newCatChoice.equals("y")){
                        edit=true;
                        break;
                    }else if(newCatChoice.equals("n")){
                        break;
                    }
                }
                if (edit){
                    System.out.println("Editing main category '"+newCat+"'");
                    editCat(newCat);
                }
            }
        }


    }
    public void editCat(String name){
        HashMap<String,ArrayList<String>> relevantMap=map.get(name);
        Set<String> keys=relevantMap.keySet();
        for (String elem:keys){
            System.out.println("+"+elem);
        }
        String question="Do you want to add a new subcategory for the category '"+name+"' (0) or edit a current subcategory (1):";
        int choice=prod.giveValidEntry(0,1,question);
        if (choice==0){
            ArrayList<String> emptyList=new ArrayList<>();
            System.out.println("What should this subcategory be called?");
            String subCatName;
            while (true){
                subCatName=scanner.nextLine();
                if (!relevantMap.containsKey(subCatName)){
                    map.get(name).put(subCatName,emptyList);
                    FileFromMap.makeFile(map);
                    break;
                }else{
                    System.out.println("This subcategory already exists.  Would you like to edit it? (y/n)");
                    String opChoice=scanner.nextLine();
                    //Call editOptions()
                }
            }
        }else if(choice==1){
            System.out.println("What subcategory would you like to edit:");
            while (true){
                String editSubCatName=scanner.nextLine();
                if(relevantMap.containsKey(editSubCatName)){
                    System.out.println("Editing subcategory '"+editSubCatName+"'");
                }
            }
        }

    }

    public static void main(String[] args) {
        useMap magpie=new useMap();
        magpie.addCat();
    }
}
