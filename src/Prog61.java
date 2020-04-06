public class Prog61 extends BaseTestClass {
    public static void main(String... args){

        int[] arr = new int[]{1, 7, 10, 13, 19, 20, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91};
        for (int a :
                arr) {
            println(String.valueOf(isHappy(a)));

        }
    }

    public static boolean isHappy(int n) {

        long slow = n;
        long fast = -n;

        while(slow!=fast){
            slow = sumOfSquareOfDigits(slow);
            fast =  sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
        }

        return slow==1;
    }

    public static long sumOfSquareOfDigits(long n){
        long current = n;
        long sum  = 0;
        while(current!=0){
            long r = current%10;
            sum = (int) (sum  + Math.pow(r,2));
            current = current/10;
        }

        return sum;
    }

}
