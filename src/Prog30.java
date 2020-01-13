import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Prog30 extends BaseTestClass {

    public static void main(String[] args) {
        print(topKFrequent(new int[]{1,1,1,2,4,4,4,4,2}, 2).toString());
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Map.Entry<Integer, Integer>> pQueue =
                new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int a : nums) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        pQueue.addAll(entrySet);

        int i = 0;
        if(k>=nums.length){
            k=nums.length;
        }
        for(i=0;i<k;i++){
            ans.add(pQueue.poll().getKey());
        }

        return ans;

    }
}
