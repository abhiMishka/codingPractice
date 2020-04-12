import java.util.Comparator;
import java.util.PriorityQueue;

public class Prog76 extends BaseTestClass {

    public static void main(String... args) {
        println(String.valueOf(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})));
    }

    public static int lastStoneWeight(int[] stones) {

        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s :
                stones) {
            priorityQueue.add(s);
        }
        while (priorityQueue.size()>1) {
            priorityQueue.add(priorityQueue.poll()-priorityQueue.poll());
        }
        return priorityQueue.poll();
    }
}
