package manager;
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
        if (log.hashedPass()==hashVal){
            return true;
        }
        else{
            return false;
        }
    }
    public static void loginUI(){
        login log=new login();
        boolean ready=false;
        for (int i=0;i<3;i++){
            if (log.checker()){
                ready=true;
                System.out.println("Access granted.");
                break;
            }
            else{
                System.out.println("Wrong password.  You have "+(2-i)+" remaining attempts.");
                if (3-i<=0){
                    System.out.println("Try again later.");
                    break;
                }
            }
        }
    }
}
