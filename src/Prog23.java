/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */

public class Prog23 extends BaseTestClass {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
    }
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[1] = nums[0];
        output[0] = nums[1];

        int totalMul = nums[0]*nums[1];

        if(nums.length>2){
            for(int i=2;i<nums.length;i++){

            }
        }

        return output;

    }
}
