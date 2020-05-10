import java.util.Arrays;

public class Prog95 extends BaseTestClass {
    public static void main(String... args) {
//        canJump(new int[]{2,3,1,1,4});
//        canJump(new int[]{3,2,1,0,4});
        println("can jump : " + canJump(new int[]{2, 0}));
        println("can jump : " + canJump(new int[]{3,2,1,0,4}));
        println("can jump : " + canJump(new int[]{2,3,1,1,4}));
    }

    static boolean isPossible = false;
    static boolean stop = false;

    public static boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[nums.length-1] = true;
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] == 0) canJump[i] = false;
        }

//        println(Arrays.toString(canJump));

        for(int i = nums.length-2;i>=0;i--){
            int val = nums[i];
            boolean possible = false;
            for(int j=1;j<=val;j++){
                int nxt = i + j;
//                println("nxt : " +nxt);
                if(nxt<nums.length){
                    possible = possible || canJump[nxt];
                    if(possible) break;
                }
            }
            canJump[i] = possible;
        }

//        println(Arrays.toString(canJump));

        return canJump[0];
    }

    public static boolean canJumpRec(int[] nums, int current, boolean[] canJump) {

        if (current > nums.length - 1) return false;

        if(current<0) return false;

        if(canJump[current]) return true;

        if (current == nums.length - 1) {
            return true;
        }

        if (nums[current] == 0) return false;

        int val = nums[current];
        boolean can = false;
        for (int i = 1; i <= val; i++) {
             can = canJump[current-1] || canJumpRec(nums, current + i, canJump);
        }

        canJump[current] = can;

        if (!isPossible) {
            stop = true;
            return false;
        }

        return isPossible;

    }


}

