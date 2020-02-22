package general;

import manager.login;
import user.betterPicker;

import java.util.ArrayList;
import java.util.Scanner;

public class Hub {
    static Scanner scanner=new Scanner(System.in);
    public void nav(){
        System.out.println("Are you a manager (m) or a user (u)?:");
        String role=scanner.nextLine();
        if (role.equals("m")){
            login.loginUI();
        }else if(role.equals("quit")){
            System.exit(0);
        }
        else{
            user.Passer object=betterPicker.choose();
            ArrayList<String> features=object.getObject().getItems();
            for (String elem:features){
                System.out.println(elem);
            }
            System.out.println("Score is: "+(object.getObject().getScore()/object.getMaxScore())*100+"%");
        }
        }

    public static void main(String[] args) {
        while (true) {
            Hub hub = new Hub();
            hub.nav();
        }
    }
    }

