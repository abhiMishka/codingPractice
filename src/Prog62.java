public class Prog62 extends BaseTestClass {

    public static void main(String... args){
        int[] arr = new int[]{4,-1,2,1};

        print(maxSubArray(arr));

    }

//    public static int maxSubArray(int[] nums) {
//        int ans = nums[0];
//
//        int[] maxSumArray = new int[nums.length];
//
//        maxSumArray[0] = nums[0];
//
//        for(int i=1;i<nums.length;i++){
//            int val = Math.max(maxSumArray[i-1]+nums[i],nums[i]);
//            maxSumArray[i] = val;
//            if (val>ans) ans = val;
//        }
//
//        return ans;
//    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            int val = Math.max(prev+nums[i],nums[i]);
            prev = val;
            if (val>ans) ans = val;
        }

        return ans;
    }
}
