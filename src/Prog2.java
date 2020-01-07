import java.util.HashMap;

public class Prog2 {


    public static void main(String... args){
        int[] arr = twoSum2(new int[]{1,2,3,4,5},4);

        for (int i =0;i<arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int first = -1; int second = -1;
        int firstInd = -1; int secondInd = -1;
        boolean done = false;
        for (int i = 0; i < nums.length;i++){
            first = nums[i];
            firstInd  = i;
            int a = target - first;
            for(int j = i+1 ; j < nums.length;j++){
                if(nums[j] == a){
                    second = a;
                    secondInd = j;
                    done = true;
                    break;
                }
            }
            if(done) break;

        }
        return new int[]{firstInd,secondInd};
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int i =0;
        for(int n : nums) {
            int complement = target - n;
            if(hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement),i};
            }else{
                hashMap.put(n,i);
            }
            i++;
        }

        return new int[]{-1,-1};


    }


}
