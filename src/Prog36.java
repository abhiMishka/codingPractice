/**
 * https://leetcode.com/problems/house-robber/
 */
public class Prog36 extends BaseTestClass {

    public static void main(String... args) {
        print("\n rob : " + rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        int[] maxRob = new int[nums.length];

        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (nums.length == 3) {
            if (nums[0] + nums[2] > nums[1]) {
                maxRob[2] = nums[0] + nums[2];
            } else {
                maxRob[2] = nums[1];
            }
            return maxRob[2];
        }

        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                maxRob[0] = nums[0];
            } else if (i == 1) {
                if (nums[1] > nums[0]) {
                    maxRob[1] = nums[1];
                } else {
                    maxRob[1] = nums[0];
                }
            } else if (i == 2) {
                if (nums[0] + nums[2] > nums[1]) {
                    maxRob[2] = nums[0] + nums[2];
                } else {
                    maxRob[2] = nums[1];
                }
            } else {
                maxRob[i] = Math.max(maxRob[i - 2] + nums[i], maxRob[i - 1]);
            }

        }

        return maxRob[nums.length - 1];
    }
}
