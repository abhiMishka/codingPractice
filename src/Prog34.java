import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/submissions/
 */
public class Prog34 extends BaseTestClass {
    public static void main(String... args) {
        moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
    }

    public static void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 1;

        while(p1 < nums.length && p2 < nums.length){
            if(nums[p1]!=0) {
                p1++;
            }else{
//                int nonZeroPos = findNonZeroPos(nums,p2);
//                if(nonZeroPos==-1) break;
                if(p2>p1) {
                    swap(nums, p2, p1);
//                    p2=nonZeroPos;
                }
//                else{
                    p2++;
//                }
                print(Arrays.toString(nums)+"\n");

            }
        }


    }

    public static int findNonZeroPos(int[] nums,int startIndx){
        int pos = -1;
        for(int i=startIndx;i<nums.length;i++){
            if(nums[i]!=0){
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
