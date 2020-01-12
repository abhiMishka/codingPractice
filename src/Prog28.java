import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class Prog28 extends BaseTestClass {
    public static void main(String[] args) {
        print(String.valueOf(canPartition(new int[]{23,13,11,7,6,5,5})));
    }

    public static boolean canPartition(int[] nums) {
        boolean isPossible = false;
        int i=0;
        int j=0;
        int total = 0;
        List<Integer> list = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            total = total + nums[i];
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(i=0;i<nums.length;i++){
            nums[i] = list.get(i);
        }
        print(Arrays.toString(nums)+"\n");
        if(total%2!=0) return isPossible;
        i = 0;
        int half = total/2;
        int sum = 0;
        boolean calc = true;
        while(i<nums.length && j<nums.length){
            int current = nums[i];

            if(calc) {
                sum = sum + current;
            }

            if(j>i) return false;

            if(sum==half){
                return true;
            }else if(sum>half){
                sum = sum - nums[j];
                j++;
                calc = false;
            }else{
                i++;
                calc = true;
            }
        }

        return isPossible;
    }
}
