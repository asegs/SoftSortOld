package general;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Random;

public class populator {
    static String[] styleArr =new String[]{"Clip","Spear","Tanto","Sheepsfoot"};
    static String[] brandArr =new String[]{"Hinderer","Spyderco","Medford","CRKT","Benchmade","Buck","Ruike","Kizer","Cold Steel"};
    static String[] colorArr =new String[]{"Black","Silver","Brown","Grey","Blue"};
    static String[] openerArr =new String[]{"Flipper","Thumb stud","Thumb hole","Nail nick","Thumb disk","Fixed"};
    static String[] originArr =new String[]{"USA","China","Italy","Japan","Taiwan"};
    static String[] steelArr =new String[]{"CPM-S35VN","D2","M390","CPM-S30V","CTS-XHP","Stainless","A2","CPM-154","CPM-20CV","8Cr13-MoV"};
    static String[] gripArr =new String[]{"Aluminum","Titanium","G10","Rubber","Wood","Carbon fiber"};
    static String[] designerArr =new String[]{"Rick Hinderer","Jesper Voxnaes","Jason Brous","Allen Elishewitz","Other","Other","Other","Other"};
    static String[] finishArr =new String[]{"Black","Bead blast","Acid stonewash"};
    static String[] useArr =new String[]{"EDC","Collection","Hard use","Culinary","Tactical"};
    public static String filler(){
        Random random= new Random();
        String brand=brandArr[random.nextInt(brandArr.length)];
        int length=random.nextInt(18);
        int weight=random.nextInt(16);
        String style=styleArr[random.nextInt(styleArr.length)];
        int price=random.nextInt(300);
        boolean engraving=random.nextBoolean();
        String color=colorArr[random.nextInt(colorArr.length)];
        String opener=openerArr[random.nextInt(openerArr.length)];
        int rating=random.nextInt(5);
        String origin=originArr[random.nextInt(originArr.length)];
        String steel=steelArr[random.nextInt(steelArr.length)];
        String grip=gripArr[random.nextInt(gripArr.length)];
        String designer=designerArr[random.nextInt(designerArr.length)];
        String finish=finishArr[random.nextInt(finishArr.length)];
        String use=useArr[random.nextInt(finishArr.length)];
        return brand+" "+length+""+weight+" "+style+","+price+","+length+","+style+","+engraving+","+brand+","+color+","+opener+","+rating+","+origin+","+steel+","+weight+","+designer+","+finish+","+use+"\n";

    }
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("metaknives.txt");
            for (int i=0;i<100000;i++) {
                String name=filler();
                myWriter.write(name);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
