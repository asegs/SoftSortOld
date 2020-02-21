package manager;
import general.fileEditor;
import general.fileReader;

import java.time.Instant;
import java.util.Scanner;

public class login {
    static int hashVal=-758644372;
    static public int hashedPass(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your manager password:");
        String entry=scanner.nextLine();
        return entry.hashCode();

    }
    static public boolean checker(){
        login log=new login();
        return hashedPass() == hashVal;
    }
    public static void loginUI(){
        long currentTime = Instant.now().getEpochSecond();
        String nextTimeAndCount=fileReader.reader("SoftSort/src/general/time.txt","\n");
        String[] lst=nextTimeAndCount.split("\n",0);
        long nextTime=Long.parseLong(lst[0]);
        if (nextTime==0){
            nextTime=currentTime-1;
        }
        int count=Integer.parseInt(lst[1]);
        if (nextTime<currentTime) {
            for (int i = 0; i < 3; i++) {
                if (checker()) {
                    System.out.println("Access granted.");
                    count=0;
                    nextTime=0;
                    String time=nextTime+"\n"+count;
                    fileEditor.replaceFile("SoftSort/src/general/time.txt",time,false);
                    useMap.home();
                    break;
                } else {
                    System.out.println("Wrong password.  You have " + (2 - i) + " remaining attempts.");
                    count+=1;
                    if (count>0){
                        nextTime+=10*count;
                    }
                    String time=nextTime+"\n"+count;
                    fileEditor.replaceFile("SoftSort/src/general/time.txt",time,false);
                }
            }
        }
        System.out.println("Try again later.");
        System.exit(0);
    }
}
