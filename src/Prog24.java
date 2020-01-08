import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */

public class Prog24 extends BaseTestClass {

    public static void main(String[] args) {
        String sentence = " abhishek is   awesome  ";
//        print(reverseWords(sentence));
        print(findMaxSumSubArray(3,new int[]{2,1,5,1,3,2}));
    }

    /**
     * 2nd attempt
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] t = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = t.length-1; i >= 0; i--){
            if(t[i].isEmpty())
                continue;
            else {
                sb.append(t[i]);
                if(i > 0)
                    sb.append(" ");
            }
        }
        return sb.toString();
//        s=s.trim();
//        if(s.isEmpty()) return s;
//
//        int i =  s.length()-1;
//        StringBuilder reverseString = new StringBuilder();
//        StringBuilder word = new StringBuilder();
//        boolean canAddSpace = true;
//        while(i>=0){
//            if(s.charAt(i)==' '){
//                reverseString.append(word.reverse().toString().trim());
//                word = new StringBuilder();
//                if(canAddSpace) {
//                    reverseString.append(" ");
//                    canAddSpace = false;
//                }
//            }else {
//                canAddSpace = true;
//                word.append(s.charAt(i));
//            }
//            i--;
//        }
//        reverseString.append(word.reverse().toString().trim());
//
//        return reverseString.toString().trim();

    }

    /**
     * 1st attempt
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s=s.trim();
        if(s.isEmpty()) return s;

        String[] strArray = s.split(" ");

        int i =  s.length()-1;
        StringBuilder reverseString = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(i>=0){
            boolean canAddSpace = false;
            if(s.charAt(i)==' '){
                while(!stack.empty()){
                    reverseString.append(stack.pop());
                    canAddSpace = true;
                }
                if(canAddSpace) {
                    reverseString.append(" ");
                    canAddSpace = false;
                }
            }else {
                stack.push(s.charAt(i));
            }
            i--;
        }

        while(!stack.empty()){
            reverseString.append(stack.pop());
        }

        return reverseString.toString().trim();
    }


    public static int findMaxSumSubArray(int k, int[] arr) {
        int sum = 0;
        int maxSum = 0;
        for (int i=0;i<arr.length;i++){
            if(i<k){
                sum=sum+arr[i];
                maxSum=sum;
            }else{
                sum=(sum-arr[i-k])+arr[i];
                if(maxSum<sum){
                    maxSum=sum;
                }
            }
        }
        return maxSum;
    }


}
