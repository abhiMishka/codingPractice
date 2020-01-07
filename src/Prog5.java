public class Prog5  {

    public static void main(String... args) {

        String testString = "abcabcbb";

        int answer = lengthOfLongestSubstring(testString);

        print("answer : " +answer);

    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int currentCount = 0;
        char prevStr = (s.charAt(0));

        for(int i = 0;i<s.length();i++){
            char str = (s.charAt(i));


            if(prevStr == str){
                currentCount++;
            }else{
                if(length<currentCount){
                    length = currentCount;
                }
                currentCount = 1;
            }
            if(length<currentCount){
                length = currentCount;
            }
            print("current  : " +String.valueOf(str) +" , prev : " +prevStr
            + " , currentCount : "  +currentCount + " , length : " +length);

            prevStr = str;

        }


        return length;

    }

    public static void print(String message){
        System.out.println(message);
    }

    }
