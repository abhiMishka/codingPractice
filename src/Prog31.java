import java.util.ArrayList;
import java.util.Collections;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

public class Prog31 extends BaseTestClass {

    public static void main(String[] args) {
        print(findKthLargest(new int[]{1}, 1));
    }

    public static int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : nums) list.add(a);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}
