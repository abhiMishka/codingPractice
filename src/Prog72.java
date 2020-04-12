public class Prog72 extends BaseTestClass{
    public static void main(String... args){

        int[] input = new int[]{123,456,12345,1,-429,2147483647};
        int[] ans = new int[]{321,654,54321,1,-924,0};

        for (int i = 0; i < input.length; i++) {
            println((reverse(input[i])==ans[i])?"PASSED":"FAILED");
        }

    }

    public static int reverse(int x) {
        int reversed = 0;
        int r;
        int isNegative = x<0?1:0;
        if (isNegative==1) x = -x;
        while((x)>0) {
            if(reversed > Integer.MAX_VALUE/10 || reversed < Integer.MIN_VALUE/10){
                return 0;
            }
            r = x % 10;
            x = x / 10;
            reversed = reversed*10 + r;

        }
        if(isNegative==1) return  -reversed;

        return reversed;
    }

}
