import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prog6  {

    public static void main(String... args) {

        String testString = "pwwkew";

        int answer = lengthOfLongestSubstring(testString);

        print("answer : " +answer);

    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int currentCount = 0;

        ArrayList<Character> strList = new ArrayList();

        for(int j=0 ; j<s.length();j++) {
            strList.clear();
            currentCount = 0;
//            print("=============================================\n");
//            print("value of j : " +j +"\n");
            for (int i = j; i < s.length(); i++) {
                char str = (s.charAt(i));

//            print("list : " +strList +" , currentCount : " +currentCount);
//            print("\n");
                if (strList.contains(str)) {
                    if (length < currentCount) {
                        length = currentCount;
                    }
                    strList.clear();
                    strList.add(str);
                    currentCount = 1;
                } else {
                    currentCount++;
                    strList.add(str);
                }

                if (length < currentCount) {
                    length = currentCount;
                }
            }

        }


        return length;

    }

    private static void print(ArrayList<Character> strList) {
        for (Character c :
                strList) {
            print(String.valueOf(c));
        }
    }

    public static void print(String message){
        System.out.print(message);
    }

}
