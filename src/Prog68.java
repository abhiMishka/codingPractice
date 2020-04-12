import java.util.Arrays;

public class Prog68 extends BaseTestClass {
    public static void main(String... args) {
        rotate(new int[]{1, 2, 3, 4, 5}, 0);
        rotate(new int[]{1, 2, 3, 4, 5}, 1);
        rotate(new int[]{1, 2, 3, 4, 5}, 2);
        rotate(new int[]{1, 2, 3, 4, 5}, 3);
        rotate(new int[]{1, 2, 3, 4, 5}, 4);
        rotate(new int[]{1, 2, 3, 4, 5}, 5);
        rotate(new int[]{1,2,3,4,5},6);
        rotate(new int[]{1},6);
        rotate(new int[]{},6);
    }

    public static void rotate(int[] nums, int k) {
//        while (k-- >0) {
//            for (int i = nums.length - 1; i >= 1; i--) {
//                nums[i] = nums[i] ^ nums[i - 1];
//                nums[i - 1] = nums[i] ^ nums[i - 1];
//                nums[i] = nums[i] ^ nums[i - 1];
//            }
//        }

        if(nums.length == 0) return;

         k  =  k % nums.length;

        int[] tempArr = new int[nums.length];

        int diff = nums.length - k;
        int count = 0;

        for (int i = diff; i < nums.length; i++) {
            tempArr[count++] = nums[i];
        }

        for (int i = 0; i < diff; i++) {
            tempArr[count++] = nums[i];
        }

        System.arraycopy(tempArr, 0, nums, 0, nums.length);

        println(Arrays.toString(nums));

    }

}
