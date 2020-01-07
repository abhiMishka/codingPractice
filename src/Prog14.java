import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prog14 extends BaseTestClass{

    public static char[] getCharArray() {
        return new char[]{'a'};
    }


    public static void main(String... args) {

//       reverseString(getCharArray());

        reverse(120);

    }

    public static char[] reverseString(char[] s) {

        int i = 0;
        int j = s.length-1;
        char tmp;
        while (i<s.length/2){
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }

        return s;

//        print("output  : " + Arrays.toString(s));

    }

    public static int reverse(int x) {

      boolean isNeg = x<0;

      x = Math.abs(x);

      StringBuilder stringBuilder = new StringBuilder();
      if(isNeg) stringBuilder.append('-');
      while(x>=10){
          int out = x%10;
          stringBuilder.append(out);
          x = x/10;
      }
      stringBuilder.append(x);

//      print("Reversed : " +stringBuilder.toString());

      try {
          return (Integer.valueOf(stringBuilder.toString()));
      }catch (Exception e){
          return 0;
      }

    }

}
