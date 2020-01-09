/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class Prog25 extends BaseTestClass {


    public static void main(String[] args) {
        print(minSubArrayLen(6,new int[]{10,2,3}));
    }

    //todo improve solution
    public static int minSubArrayLen(int s, int[] nums) {

        if(nums.length==0) return 0;

        if(nums.length==1){
            if(nums[0]==s){
                return 1;
            }
            return 0;
        }

        int minArrayLength = -1;
        int startIndx = 0;
        int endIndx =  1;

        int sum = nums[0];
        boolean startIndxIncreased = false;
        boolean dont = false;

        if(sum>=s){
            minArrayLength = 0;
        }

        while(endIndx!=(nums.length-1) || startIndx!=(nums.length-1)){

            if(!dont) {
                sum = sum + nums[endIndx];
            }
            print("sum : "+sum+"\n");


            if(sum>=s){
                int len = endIndx-startIndx;
                print("strt :" +startIndx +" endInd : " +endIndx +"\n");
                print("len :" +len +"\n");
                if(minArrayLength==-1){
                    minArrayLength = len;
                }else if(len<minArrayLength) {
                    minArrayLength = len;
                }
                if(startIndx<nums.length-1) {
                    sum =sum - nums[startIndx];
                    startIndx++;
                    dont = true;
                }
//                if(endIndx<nums.length-1) {
//                    endIndx++;
//                    dont = false;
//                }
            }else {
                if(endIndx<nums.length-1) {
                    endIndx++;
                    dont = false;
                }else{
                    break;
                }

            }
        }

        if(sum>=s) {
            int len = endIndx - startIndx;
            if (minArrayLength == -1) {
                minArrayLength = len;
            } else if (len < minArrayLength) {
                minArrayLength = len;
            }
        }

        return minArrayLength==-1?0:(minArrayLength+1);

    }

}
