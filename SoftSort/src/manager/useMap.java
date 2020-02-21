package manager;

import general.populator;

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
                    if (opChoice.equals("y")) {
                        editSubCat(name, subCatName);
                        FileFromMap.makeFile(map);
                    }
                    break;
                }
            }
        }if(choice==1){
            System.out.println("What subcategory would you like to edit:");
            while (true){
                String editSubCatName=scanner.nextLine();
                if(relevantMap.containsKey(editSubCatName)){
                    System.out.println("Editing subcategory '"+editSubCatName+"'");
                    editSubCat(name,editSubCatName);
                    FileFromMap.makeFile(map);
                    break;
                }
            }
        }

    }
    public static void editSubCat(String name,String subName){
        ArrayList<String> relevantArrayList=map.get(name).get(subName);
        for (String elem:relevantArrayList){
            System.out.println("-"+elem);
        }
        String subQuestion="Do you want to add new options (0) or edit current options (1)?";
        int subChoice=prod.giveValidEntry(0,1,subQuestion);
        if (subChoice==0){
            System.out.println("Enter the new options for '"+name+"."+subName+"', separated only by commas:");
            String entry=scanner.nextLine();
            String[] lst=entry.split(",",0);
            for (String item:lst){
                if (!relevantArrayList.contains(item)){
                    relevantArrayList.add(item);
                }
            }
        }
        if (subChoice==1){
            System.out.println("Enter the options to remove from '"+name+"."+subName+"', separated only by commas.");
            String removals=scanner.nextLine();
            String[] removeLst=removals.split(",",0);
            for (String item:removeLst){
                if (relevantArrayList.contains(item)){
                    relevantArrayList.remove(item);
                }
            }
        }
        map.get(name).put(subName,relevantArrayList);
        FileFromMap.makeFile(map);

    }
    public static boolean addPlainCat(String name){
        boolean success=false;
        if (map.containsKey(name)){
            System.out.println("Category already exists.");
        }else{
            HashMap<String,ArrayList<String>> newCat=new HashMap<>();
            map.put(name,newCat);
            FileFromMap.makeFile(map);
            System.out.println("Added main category '"+name+"'.");
            success=true;
        }
        return success;
    }

    public static void home(){
        boolean exit=false;
        useMap use=new useMap();
        while (!exit){
            String homeQuestion="Enter what you want to do, starting with 'add', 'edit', 'populate', or 'fleshed', followed by 'cat'/'subcat'/'options'/." +
                    "\nFleshed allows you to fill create and fill out a category instead of just defining it.  ";
            System.out.println(homeQuestion);
            String entry=scanner.nextLine();
            String[] parsedEntry=entry.split(" ",0);
            if (parsedEntry.length==2) {
                if (parsedEntry[0].equals("populate")&&parsedEntry[1].equals("cat")){
                    populator.createData();
                }
                if (parsedEntry[0].equals("add")) {
                    if (parsedEntry[1].equals("cat")) {
                        use.addCat();
                    }
                    if (parsedEntry[1].equals("subcat")) {
                        Set<String> catNames=map.keySet();
                        for (String elem:catNames){
                            System.out.println("@"+elem);
                        }
                        System.out.println("Which category do you want to add to?:");
                        String subCatName=scanner.nextLine();
                        use.editCat(subCatName);
                    }
                    if (parsedEntry[1].equals("options")) {
                        Set<String> catNames=map.keySet();
                        for (String elem:catNames){
                            System.out.println("@"+elem);
                        }
                        System.out.println("Which category do you want to add to?:");
                        String catName=scanner.nextLine();
                        Set<String> opNames=map.get(catName).keySet();
                        for (String elem:opNames){
                            System.out.println("+"+elem);
                        }
                        System.out.println("Which subcategory do you want to add to?");
                        String subCatName=scanner.nextLine();
                        use.editSubCat(catName,subCatName);

                    }
                }
                if (parsedEntry[0].equals("edit")) {
                    if (parsedEntry[1].equals("cat")) {

                    }
                    if (parsedEntry[1].equals("subcat")) {

                    }
                    if (parsedEntry[1].equals("options")) {

                    }
                }
                if (parsedEntry[0].equals("fleshed")){
                    if (parsedEntry[1].equals("cat")){
                        String catName="";
                        boolean mainSuccess=false;
                        while (!mainSuccess){
                            System.out.println("Enter the new category name:");
                            catName=scanner.nextLine();
                            mainSuccess=use.addPlainCat(catName);
                        }
                        System.out.println("Enter the names of your subcategories for '"+catName+"', separated only by commas:");
                        String subCatSep=scanner.nextLine();
                        String[] subCatLst=subCatSep.split(",",0);
                        for (String elem:subCatLst){
                            ArrayList<String> emptyArr=new ArrayList<>();
                            System.out.println("Enter the options to add to '"+catName+"."+elem+"', separated only by commas:");
                            String opsEntry=scanner.nextLine();
                            String[] opLst=opsEntry.split(",",0);
                            for (String item:opLst){
                                emptyArr.add(item);
                            }
                            map.get(catName).put(elem,emptyArr);
                            FileFromMap.makeFile(map);
                        }
                    }
                    if (parsedEntry[1].equals("subcat")){

                    }
                    if (parsedEntry[1].equals("options")){

                    }
                }
            }
            if (parsedEntry.length==1){
                if (parsedEntry[0].equals("quit")){
                    exit=true;
                }
                if (parsedEntry[0].equals("options")){
                    //Write options operation here
                }
            }
            else{
                System.out.println("This operation has not been added yet.");
            }
        }
    }

//    public static void main(String[] args) {
//        useMap magpie=new useMap();
//        magpie.home();
//    }
}
