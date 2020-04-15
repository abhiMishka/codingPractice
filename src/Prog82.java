import java.util.Arrays;

public class Prog82 extends BaseTestClass {
    public static void main(String... args){
        productExceptSelf(new int[]{4,3,2,1,2});
    }

    public static int[] productExceptSelf(int[] nums) {

        if (nums.length <=1) return nums;

        int[] ans = new int[nums.length];

        int[] left = new int[nums.length];

        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                left[i] = 1;
            }else if(i==1){
                left[i] = nums[i-1];
                temp = nums[i]*nums[i-1];
            }else{
                left[i]= temp;
                temp = temp*nums[i];
            }
        }
        println(Arrays.toString(left));

        temp = 1;

        for (int i = nums.length-1; i >=0; i--) {
            if(i==nums.length-1){
                ans[i]=left[i]*temp;
            }else if(i==nums.length-2){
                ans[i] = left[i]*nums[i+1];
                temp = nums[i+1];
            }else{
                temp = temp*nums[i+1];
                ans[i]= left[i]*temp;
            }
        }


        println(Arrays.toString(ans));


        return ans;

    }
}
