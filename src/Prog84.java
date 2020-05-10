import java.util.*;

public class Prog84 extends BaseTestClass {
    public static void main(String... args){
        println("ans : " +topKFrequent(new int[]{1,1,1,2,2,3},2));
        println("ans : " +topKFrequent(new int[]{1},1));
        println("ans : " +topKFrequent(new int[]{4,1,-1,2,-1,2,3},2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0) return ans;

        Map<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Node> pQ = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.j-o1.j;
            }
        });


        for (int a :
                nums) {
            if (map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }

//        printMap(map);

        Set<Integer> set = map.keySet();
        for (int key :
                set) {
            pQ.add(new Node(key,map.get(key)));
        }

        while (k-->0){
            ans.add(pQ.poll().i);
        }

        return ans;
    }

    static class Node{
        int i;
        int j;

        public Node(Integer key, Integer value) {
            i =key;
            j= value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
