public class Prog37 extends BaseTestClass {

    public static void main(String... args) {
        print("\nmaxProduct : " + maxProduct(new int[]{2, 3, -2, 4, -2}));
    }

    public static int maxProduct(int[] nums) {
        int[] maxProduct = new int[nums.length];

        maxProduct[0] = nums[0];
        maxProduct[1] = nums[0] * nums[1];
        int totalProduct = 1;


        for (int i = 1; i < nums.length; i++) {
//            maxProduct[i] = Math.max(maxProduct[i-1],)

        }


        return maxProduct[nums.length - 1];
    }

}
