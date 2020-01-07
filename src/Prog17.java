import java.util.ArrayList;

public class Prog17 {
    public static void main(String[] args) {

        String test = "(((()((" ;

        int closeCount = 0;
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        for(int i = test.length()-1; i >= 0; i--) {
            if(test.charAt(i) == '(') {
                closeCount--;
                if(closeCount >= 0){
                    arrli.remove(arrli.size() - 1);
                } else {
                    test = deleteCharAt(test, i);
                    closeCount++;
                }
            } else if (test.charAt(i) == ')'){
                closeCount++;
                arrli.add(i);
            }
        }
        for(int i = 0; i< arrli.size();i++){
            test = deleteCharAt(test, arrli.get(i));
        }
        System.out.println(test);
    }

    private static String deleteCharAt(String input, int i){
        StringBuilder input1 = new StringBuilder(input);
        input1.deleteCharAt(i);
        return input1.toString();
    }
}
