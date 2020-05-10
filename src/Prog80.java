import java.util.Stack;

public class Prog80 {

    public static void main(String... args) {

        boolean ans = checkParanthesis("()()[]{}");
        System.out.println("ans : " + ans);

        ans = checkParanthesis("()()[]{}");
        System.out.println("ans : " + ans);

        ans = checkParanthesis("(()()[]{}");
        System.out.println("ans : " + ans);

        ans = checkParanthesis("(()())[]{}");
        System.out.println("ans : " + ans);

    }

    public static boolean checkParanthesis(String s) {

        if (s == null) return false;
        if (s.isEmpty() || s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}
