import java.util.HashMap;

public class Prog93 extends BaseTestClass {
    public static void main(String... args) {

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int val : nums) {
            sum = sum + val;

            if (sumMap.containsKey((sum - k))) {
                ans = ans + sumMap.get(sum - k);
            }

            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
