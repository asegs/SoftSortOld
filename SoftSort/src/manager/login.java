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

    public static void main(String[] args) {
        login log=new login();
        System.out.println(log.checker());
    }
}
