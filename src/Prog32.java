import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class Prog32 extends BaseTestClass {
    public static void main(String... args) {
        String num1 = "123";
        String num2 = "456";

        print(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        String ans = "";
        List<String> sumList = new ArrayList<>();

        int len2 = num2.length() - 1;
        int carry = 0;
        int r = 0;
        int sum = 0;
        StringBuilder temp = new StringBuilder();
        StringBuilder zeros = new StringBuilder();
        while (len2 >= 0) {
            int digit2 = Integer.parseInt(String.valueOf(num2.charAt(len2)));
            int len1 = num1.length() - 1;
            temp = new StringBuilder();
            carry = 0;
            while (len1 >= 0) {
                int digit1 = Integer.parseInt(String.valueOf(num1.charAt(len1)));
                int product = digit2 * digit1 + carry;
                if(product>=10){
                    r = product%10;
                    carry = (product-r)/10;
                }else{
                    r = product;
                    carry = 0;
                }

                print("r  : "+r +" carry :  "+carry +"\n");
                temp.insert(0, r);
                len1--;
            }
            print("\n \n");

            temp.append(zeros);
            sumList.add(temp.toString());
            zeros.append("0");
            print(sumList.toString() +"\n");

            len2--;

        }


        return ans;

    }

}
