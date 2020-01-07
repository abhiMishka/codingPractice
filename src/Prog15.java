public class Prog15 extends BaseTestClass {

//    public static int[] getArray() {
//        return new int[]{-2,1,-3,4,-1,2,1,-5,4};
//    }
//
//
//    public static void main(String... args) {
//        int ans = maxSubArray(getArray());
//        print("ans : " +ans);
//    }
//
//
//    public static int maxSubArray(int[] nums) {
//
////        return recursiveSol(nums,nums.length-1, new int[nums.length]);
//    }
//
//    public static int recursiveSol(int[] nums,int i){
//
//        int maxSum = 0;
//        int testMaxSum  = 0 ;
//        if(i==0){
//            maxSum = nums[0];
//        }else if(i==1){
//            maxSum = nums[1]>nums[0] ? nums[0]+nums[1] : nums[0];
//        }else{
//            for(i=nums.length;i>=1;i--){
//               testMaxSum = nums[i]+nums[i-1];
//               if(testMaxSum>=maxSum){
//                   maxSum = testMaxSum;
//               }else{
//                   if(nums[i]<0){
//                       testMaxSum = nums[i-1];
//                   }else{
//
//                   }
//                   testMaxSum = nums[i];
//               }
//            }
//        }
//
//
//
//
//    }
}
