import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Prog9 extends BaseTestClass {

    private static int[] getArray() {
        return new int[]{1,1,1,2,2,3,4,4,4};
    }

    public static void main(String... args) {

        int ans = removeDuplicates(getArray());

        print(String.valueOf(ans));

    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length==0) return 0;

        int length = 0;
        int i = 1;
        int j = 1;
        int currentElement = nums[0];
        int prevElement = nums[0];

        while (j < nums.length) {
            currentElement = nums[j];
            if (currentElement == prevElement) {
                j++;
            } else {
                nums[i] = currentElement;
                prevElement = currentElement;
                length++;
                i++;
                j++;
            }
        }

//        print(Arrays.toString(nums) +"\n");

        return length+1;


    }
}
