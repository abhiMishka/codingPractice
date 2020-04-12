import java.util.HashMap;

public class Prog64 extends BaseTestClass {

    public static void main(String... args){
        println(String.valueOf(countElements(new int[]{1,3,2,3,5,0})));
        println(String.valueOf(countElements(new int[]{1,1,3,3,5,5,7,7})));
        println(String.valueOf(countElements(new int[]{1,2,3})));
        println(String.valueOf(countElements(new int[]{1,1,2})));
        println(String.valueOf(countElements(new int[]{1,1,2,2})));
    }

    private static int countElements(int[] arr) {
        int count = 0;
        HashMap<Integer,Character> occurenceMap = new HashMap<>();

        for(int number : arr){
            if(!occurenceMap.containsKey(number)){
                occurenceMap.put(number,'a');
            }
        }

        for (int number : arr){
            if(occurenceMap.containsKey(number+1)){
                count++;
            }
        }

        return count;
    }
}
