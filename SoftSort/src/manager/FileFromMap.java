package manager;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import general.*;

public class FileFromMap {
    public static void makeFile(HashMap<String,HashMap<String,ArrayList<String>>> map){
        String file="";
        Set<String> lst=map.keySet();
        System.out.println(lst);
        Iterator<String> iterator =lst.iterator();
        while (iterator.hasNext()){
            String mainName=iterator.next();
            file+="@"+mainName+"\n";
            HashMap<String,ArrayList<String>> subMap=map.get(mainName);
            Set<String> subLst=subMap.keySet();
            Iterator<String> subIterator=subLst.iterator();
            while (subIterator.hasNext()){
                String subName=subIterator.next();
                file+="+"+subName+"\n";
                ArrayList<String> options=subMap.get(subName);
                for (String elem:options){
                    file+="-"+elem+"\n";
                }
            }
        }
        System.out.println(file);
        fileEditor.replaceFile("SoftSort/src/general/categories.txt",file);
    }
}
