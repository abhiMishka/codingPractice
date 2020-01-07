import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Prog8 extends BaseTestClass {

    private static int[] getArray(){
        return new int[]{1,1,2};
    }

    public static void main(String... args) {

        int ans = removeDuplicates(getArray());

        print(String.valueOf(ans));

    }

    public static int removeDuplicates(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        int i = 0;

        for (int a :
                nums) {
            if(!hashSet.contains(a)){
                nums[i]=a;
                i++;
            }
            hashSet.add(a);
        }

//        print(Arrays.toString(nums) +"\n");



        return hashSet.size();


    }
}
