import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 */

public class Prog86 extends BaseTestClass {
    public static void main(String... args) {
//        println(String.valueOf(checkValidString("()(*)(***)(((")));
//        println(String.valueOf(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*")));
//        println(String.valueOf(checkValidString("(*)()*(")));
//        println(String.valueOf(checkValidString("(*)()*")));
//        println(String.valueOf(checkValidString("(*)()")));
//        println(String.valueOf(checkValidString("(*()")));
        println(String.valueOf(checkValidString("(*))")));
        println(String.valueOf(checkValidString("*))")));
        println(String.valueOf(checkValidString("**))")));
    }

    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
//            println("loop ; " +i +" : " +stack.toString());
            if (c == '*' || c == '(') {
                stack.push(c);
            } else  {
                int current = stack.size()-1;
                if(current<0) return false;
                int count = 0;
                boolean found = false;
                while (current>=0){
                    count++;
                    if(stack.get(current)=='('){
                        found = true;
                        break;
                    }
                    current--;
                }

                if(!found) return false;

//                println("count : " +count);

                while (count-- > 0){
                    stack.pop();
                }

            }
        }

//        printSeparation();
//        println(stack.toString());

        if(stack.isEmpty()) return true;

        int starCount = 0;
        int len = stack.size();
        while(len-- > 0){
            if(stack.peek()=='*') {
                starCount++;
                stack.pop();
            }else if(starCount>0) {
                stack.pop();
                starCount--;
            }else{
                return false;
            }
        }
//        println(stack.toString());


        return true;
    }

}
