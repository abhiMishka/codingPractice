/**
 * https://leetcode.com/problems/single-number-i/
 */
public class Prog47 extends BaseTestClass {
    public static void main(String... args) {
        singleNumber(new int[]{1, 1, 1});

    }

    public static int singleNumber(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        print("a : " + a);
        return a;
    }
}
