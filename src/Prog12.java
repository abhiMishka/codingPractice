import java.util.*;

public class Prog12 extends BaseTestClass {

    /**
     * https://leetcode.com/problems/last-stone-weight/
     * @return
     */
    public static int[] getArray1() {
        return new int[]{2,7,4,1,8,1};
    }
    private static int[] getArray2() { return new int[]{3,4}; }

    public static void main(String... args) {

        int ans = lastStoneWeight(getArray1());

        print(String.valueOf(ans));

    }

    public static int lastStoneWeight(int[] stones) {

        Queue<Integer> priorityQueue = new PriorityQueue<>(stones.length,Comparator.reverseOrder());
        for (int a :
                stones) {
            priorityQueue.add(a);
        }

        while (priorityQueue.size()>=2){
            int max1 = priorityQueue.poll();
            int max2 = priorityQueue.poll();
            int diff = max1 - max2;
            if(diff!=0){
                priorityQueue.add(diff);
            }
        }
        return priorityQueue.size()==0 ? 0 : priorityQueue.poll();

    }
}
