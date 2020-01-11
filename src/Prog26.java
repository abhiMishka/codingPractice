import java.util.HashMap;

/**
 * https://www.educative.io/courses/grokking-the-coding-interview/YQQwQMWLx80
 */

public class Prog26 extends BaseTestClass {

    public static void main(String[] args) {
        print(findLength("cbbebi",3));
    }

    public static int findLength(String str, int k) {

        int i=0;
        int j=0;
        int maxLength = -1;
        int len = 0;
        HashMap<Character,Boolean> map = new HashMap<>();

        while(i<str.length() && j<str.length()){
            char current = str.charAt(i);
            if(!map.containsKey(current)){
                map.put(current,true);
            }
            if(map.size()==k){
                len = i-j;
                if(len>maxLength){
                    maxLength = len;
                }
                i++;
            }else if(map.size()>k){
                map.remove(str.charAt(j));
                j++;
            }else{
                i++;
            }
        }

        return maxLength+1;
    }
}
