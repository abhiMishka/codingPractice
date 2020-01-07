public class Prog22 extends BaseTestClass {


    public static void main(String[] args) {

        int N = 01;
        print(numDecodings("230") + "\n");
//        print(fib2(N));


    }

    public static int numDecodings(String s) {

//        int[] ways = new int[s.length() + 1];
//        for(int i=0;i<ways.length;i++){
//            ways[i]=-1;
//        }
//        if (s.length() == 0) {
//            return 0;
//        }
//
//        if (s.length() == 1) {
//            return 1;
//        }

        if (s.endsWith("00") || s.startsWith("0")) return 0;
        return calcWays(s, 0);

    }


    public static int calcWays(String s, int sum) {
//        print(s + "\n");
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1 && s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int twoDig = Integer.valueOf(s.substring(0,2));
//        print("twoDig : " + twoDig + "\n");

        if (s.charAt(0) == '0') {
            if (twoDig > 0 && twoDig<=26) {
                calcWays(s.substring(1), sum);
            }else{
                return 0;
            }
        }

        if (s.length() == 2) {
            if (twoDig > 10 && twoDig <= 26) {
                return 2;
            } else if (twoDig <= 10) {
                return 1;
            }else{
                return 0;
            }
        }


        if (twoDig > 10 && twoDig <= 26) {
            sum = +calcWays(s.substring(1), sum) + calcWays(s.substring(2), sum);
        } else {
            sum = sum + calcWays(s.substring(1), sum);
        }

        return sum;
    }
}
