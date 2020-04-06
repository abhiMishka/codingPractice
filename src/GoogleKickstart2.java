import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GoogleKickstart2 {

    private static Stack<Integer>[] stacks;
    private static int stacksSize;
    private static int m, sum;
    private static int max;
    private static int currentStack;


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String ab = in.nextLine();
            String[] input = ab.split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            stacks = new Stack[a];
            String numbers = "";
            int ans = 0;
            for (int k = 0; k < a; k++) {
                ans = 0;
                numbers = in.nextLine();
                Stack<Integer> integerStack = new Stack<>();
                String[] nums = numbers.split(" ");
                for (int l = nums.length-1 ;l>=0;l--){
                    integerStack.push(Integer.parseInt(nums[l]));
                }
                stacks[k] = (integerStack);
                ans  = getMaximumSum(stacks,c);
            }


            System.out.println("Case #" + i + ": " + ans);
        }
    }

    public static int getMaximumSum(Stack<Integer>[] stacks, int m) {
        max = Integer.MIN_VALUE;
        stacks = stacks;
        stacksSize = stacks.length;
        m = m;
        currentStack = 0;


        getMaximumSum();


        return max;


    }


    public static void getMaximumSum() {
        if (m == 0) {
            if (sum > max)
                max = sum;
        } else {
            int aux = currentStack;
            for (int i = currentStack; i < stacksSize; i++) {
                Stack<Integer> stack = stacks[i];
                currentStack = i;
                if (!stack.isEmpty()) {
                    m--;
                    int num = stack.pop();
                    sum += num;
                    getMaximumSum();
                    sum -= num;
                    m++;
                }

            }
            currentStack = aux;
        }
    }
}
