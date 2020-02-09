import java.util.Arrays;

public class Prog41 extends BaseTestClass {

    public static void main(String... args){
        sortColors(new int[]{0,1,2,0,1,2});
    }

    public static void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;


        while(mid<=high){

            if(nums[mid]==0){
                swap(nums,mid,low);
                low++;
                mid++;

            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
                mid++;
            }

            print(Arrays.toString(nums)+"\n");

        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
