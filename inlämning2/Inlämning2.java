import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inlämning2 {
    static int count = 0;                                                                                      //uppg3,4,5*********

    public static void main(String[] args) throws FileNotFoundException { //creating File instance to reference text file in Java
        File text = new File("src/rega.txt"); //Creating Scanner instance to read File in Java
        Scanner scan = new Scanner(text);

     // String myString ="aaaa Kalle Ostar 09-111222 A(AA)";
     // String pattern = "[A-Z][a-z]+   ";
      String pattern = "abcdefghij";  //Uppg1**************
     // String pattern = "Ola";         //Uppg2**************
     // String pattern = "[aaa]{3,5}";  //Uppg3**************
     // String pattern = "[\\W]{2,}"; //Uppg4**************
     // String pattern = "[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[A-Za-z]{2,3}"; //Uppg5******
     // String pattern = "\\d{2,4}[0-9+/ -]\\d{5,10}";                        //Uppg6******
     // String pattern = "([A-Za-z])\\1{3}";                                  //Uppg7******
     // String pattern = "[A-Za-z]{3}+[/_]+[0-9]{3}";                         //Uppg8******
     // String pattern = "\\((.*?)\\)";                                       //Uppg9******
     // String pattern = "if[(].+[}]|for[(].+[}]";                            //Uppg10*****

        //   String pattern = "([0-9]( |-)?)(\(?[0-9]{3}\)?|[0-9]{3})( |-)?([0-9]{4}|[a-zA-Z0-9]{7});

        int LineNumber = 0;
        while(scan.hasNextLine()){
            String line = scan.nextLine();
     //     System.out.println("line " + LineNumber + " :" + line);
            LineNumber++;
            finder(line,pattern,LineNumber);
        }
    }
    public static void finder(String myString, String pattern, int LineNumber){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);

        while(matcher.find()){ //searches for string
            if (matcher.group().length() !=0) { //print unless length is empty.

                count++;                                                                                                    //uppg3,4,5***********
              System.out.println("1: På line "+ LineNumber+ " finns alfabetet " +matcher.group());                        //Uppg1*************
     //         System.out.println("2: På line "+ LineNumber+ " finns Ola inskrivet ");                                     //Uppg2*************
     //         System.out.println("3: på line "+ LineNumber+ " finns 3-5 a i följd "+count+"st");                          //uppg3*************
     //         System.out.println("4: på line "+ LineNumber+" finns icke godkända char inom nr eller alfabetet "+count+"st symboler");//Uppg4*
     //         System.out.println("5: på line "+ LineNumber+ " finns mailadresser "+matcher.group()+"  "+count+"st");      //Uppg5**
     //         System.out.println("6: på line "+ LineNumber+ " finns telefonnr: "+matcher.group());                        //Uppg6**
     //         System.out.println("7: på line "+ LineNumber+ " Finns "+ matcher.group());                                  //Uppg7**
     //         System.out.println("8: på line "+ LineNumber+ " Finns "+ matcher.group());                                  //Uppg8**
     //         System.out.println("9: på line "+ LineNumber+ " Finns "+ matcher.group());                                  //Uppg9**
     //         System.out.println("10: på line "+ LineNumber+ " Finns "+ matcher.group()+" "+count);                       //Uppg10*

            }
        }
    }
}