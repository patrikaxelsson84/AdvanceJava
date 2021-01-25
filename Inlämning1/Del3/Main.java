import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String[] names = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth", "Joshua", "Kevin", "Brian", "George", "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan", "Jacob", "Gary", "Nicholas", "Eric", "Jonathan", "Stephen", "Larry", "Justin", "Scott", "Brandon", "Benjamin", "Samuel", "Frank", "Gregory", "Raymond", "Alexander", "Patrick", "Jack", "Dennis", "Jerry",};
        List<MyObject> objects = new ArrayList<>(); //skapar listan

        boolean bool;
        MyObject ga = new MyObject(false, 4, "name2");

        for(int i = 0; i<50; i++){
            int val=(int)(Math.random()*49)+1;
            int Namn=(int)(Math.random()*49)+1;
            int TrueOrFalse=(int)(Math.random()*2);
            if (TrueOrFalse == 1) {
                bool=true;
            }else{
                bool=false;
            }
            MyObject gs = new MyObject(bool, val, names[Namn]); //gör en instance av objektet med värdena
            objects.add(gs); //lägger in objektet i listan

        }
        objects.add(ga);

        System.out.println("*****************");
        System.out.println("* InLuppProject *");
        System.out.println("*****************");
        System.out.println("* 1: "+Arrays.toString(objects
                .stream()
                .filter(x-> x.getValue()>20)
                .toArray()));

        System.out.println("* 2: ["+"Average: " + objects
                .stream()
                .mapToInt(x -> x
                .getValue())
                .average()
                .getAsDouble());

        System.out.println("* 3: "+Arrays.toString(objects
                .stream()
                .filter(c-> c.isBool())
                .map(z-> z.name = "this is true")
                .toArray()));
    }
}