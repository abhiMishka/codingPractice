import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 */

public class Prog7 extends BaseTestClass {
    public static void main(String... args) {

        String testString = "asjrgapa";

        int answer = lengthOfLongestSubstring(testString);

        print("answer : " +answer);

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;

        int length = 0;
        int i = 0 ; int j = 0;
        int currentCount;


        List<Character> hashSet = new ArrayList<>();
        hashSet.add(s.charAt(i));

        while(i<s.length() && j<s.length()){

            if(!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j));
                currentCount = hashSet.size();
                j++;
            }else{
                currentCount = hashSet.size();
                if(length<currentCount){
                    length = currentCount;
                }
                hashSet.remove(0);
                i++;
            }

            if(length<currentCount){
                length = currentCount;
            }

        }
        return length;

    }


}
