import java.util.ArrayList;
import java.util.List;

public class Prog69 extends SubBaseClass {

    public static void main(String... args) {

        println("ans : " +((backspaceCompare("ab#c", "ad#c")==true)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("ab##", "c#d#")==true)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("a##c", "#a#c")==true)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("a#c", "b")==false)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("###", "b")==false)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("###", "##")==true)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("bbb##", "b")==true)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("bbb##", "##b")==true)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("bbb##", "##b#")==false)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("b#bb##", "##b#")==true)?"PASSED" :"FAILED")); //true
        println("ans : " +((backspaceCompare("xywrrmp", "xywrrmu#p")==true)?"PASSED" :"FAILED")); //true
    }

    public static boolean backspaceCompare2(String S, String T) {

        boolean isValid = true;

        int p1 = S.length() - 1;
        int p2 = T.length() - 1;

        int p1Hash = 0;
        int p2Hash = 0;

        char compare1 = ' ', compare2 = ' ';

        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0) {
                if (S.charAt(p1) == '#') {
                    compare1 = ' ';
                    while (p1 >= 0) {

                        if (S.charAt(p1) == '#') {
                            p1Hash++;
                            p1--;
                        }else{
                            break;
                        }

                    }

                } else {
                    while (p1Hash>0 && S.charAt(p1) != '#'){
                        p1Hash --;
                    }
                    compare1 = S.charAt(p1);
                    p1--;
                }

            }

            if (p2 >= 0) {
                if (T.charAt(p2) == '#') {
                    compare2 = ' ';

                    while (p2 >= 0) {

                        if (T.charAt(p2) == '#') {
                            p2Hash++;
                            p2--;
                        }else{
                            break;
                        }
                    }

                } else {
                    compare2 = T.charAt(p2);
                    p2--;
                }

            }
            isValid = compare1 == compare2;
            println("compare1: " + compare1 + " and2 " + compare2);

            if (compare1 == ' ' || compare2 == ' ') {
                continue;
            } else {
                if (!isValid) return isValid;
            }

        }


        return isValid;
    }

    public static boolean backspaceCompare(String S, String T) {


        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        int p1 = S.length() - 1;
        int p2 = T.length() - 1;

        int p1Hash = 0;
        int p2Hash = 0;

        while (p1>=0){
            if(S.charAt(p1)=='#'){
                p1Hash++;
            }else{
                if(p1Hash>0){
                    p1Hash--;
                }else{
                    first.add(0,Character.toString(S.charAt(p1)));
                }
            }
            p1--;
        }

        while (p2>=0){
            if(T.charAt(p2)=='#'){
                p2Hash++;
            }else{
                if(p2Hash>0){
                    p2Hash--;
                }else{
                    second.add(0,Character.toString(T.charAt(p2)));
                }
            }
            p2--;
        }

//        println("final String : " +first.toString());

        return first.equals(second);
    }
}
