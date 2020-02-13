package manager;
import java.util.ArrayList;
import java.util.HashMap;
import general.*;

public class MapFromFile {
    static fileReader reader = new fileReader();
    static fileEditor editor = new fileEditor();

    public static HashMap<String,HashMap<String,ArrayList<String>>> makeMap() {
        String file = fileReader.reader("SoftSort/src/general/categories.txt", "\n");
        HashMap<String, HashMap<String, ArrayList<String>>> mainMap = new HashMap<>();
        while (true) {
            if (file.contains("@")) {
                String catName = file.substring(file.indexOf("@")+1, file.indexOf("\n"));
                int start=file.indexOf("+");
                int end=file.indexOf("@",1);
                String subString="";
                String remainingString="";
                if (start<end) {
                    subString = file.substring(start, end);
                    remainingString = file.substring(end, file.length());
                }else{
                    subString=file.substring(start,file.length());
                }
                HashMap<String, ArrayList<String>> subCatMap = new HashMap<>();
                while (true) {
                    if (subString.contains("+")) {
                        ArrayList<String> subCatArray = new ArrayList<>();
                        String subCatName = subString.substring(subString.indexOf("+")+1, subString.indexOf("\n"));
                        int subStart=subString.indexOf("-");
                        int subEnd=subString.indexOf("+", 1);
                        String subCat;
                        String remainingCat="";
                        if (subStart<subEnd) {
                            subCat = subString.substring(subStart, subEnd);
                            remainingCat = subString.substring(subEnd, subString.length());
                        }else{
                            subCat=subString.substring(subStart,subString.length());
                        }

                        String[] lst = subCat.split("\n", 0);
                        for (String elem : lst) {
                            if (elem.substring(0, 1).equals("-")) {
                                subCatArray.add(elem.substring(1,elem.length()));
                            }
                        }
                        subCatMap.put(subCatName, subCatArray);
                        subString = remainingCat;
                    } else {
                        break;
                    }

                }
                mainMap.put(catName, subCatMap);
                file = remainingString;
            } else {
                break;
            }
        }
        return mainMap;
    }

    public static void main(String[] args) {
        HashMap<String,HashMap<String,ArrayList<String>>> map=makeMap();
        map.get("Knives").get("Steel").add("Damascus");
        FileFromMap.makeFile(map);
    }
    }

