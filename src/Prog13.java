import java.util.Stack;

public class Prog13 extends BaseTestClass {

    public static void main(String... args) {

        int ans = longestValidParentheses("()()");

        print(String.valueOf(ans));

    }

    public static int longestValidParentheses(String s) {
        int valid = 0;
        int longestValid = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
           if(s.charAt(i)==')'){
               if(!stack.empty()){
                   stack.pop();
                   valid+=2;
                   if(valid>longestValid) longestValid = valid;
               }else{
                   valid = 0;
               }
           }else{
               stack.push('(');
           }
        }

        return longestValid;

    }
}
