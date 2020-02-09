public class Prog38 extends BaseTestClass {

    public static void main(String... args) {
        print("\nmaxSum : " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = 0;
        int i = 0;
        int j = 1;
        int localSum = Integer.MIN_VALUE;
        while (i < nums.length && j < nums.length) {
            if(localSum>nums[i] + nums[j]){
                localSum = nums[i] + nums[j];
            }else{

            }
        }

        return maxSum;
    }
}
