import java.util.*;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class Prog45 extends BaseTestClass {

    public static void main(String... args) {

        print(findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5).toString());
        print("\n");

        print(findClosestElements(new int[]{1,2,3,4,5}, 4, -1).toString());
        print("\n");

        print(findClosestElements(new int[]{1,2,3,4,5}, 4, 3).toString());
        print("\n");

        print(findClosestElements(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2).toString());
        print("\n");

        print(findClosestElements(new int[]{1,1}, 1, 1).toString());
        print("\n");

        print(findClosestElements(new int[]{1,2,5,5,6,6,7,7,8,9}, 7, 7).toString());
        print("\n");


    }


//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
//    public ListNode reverseList(ListNode head){
//        ListNode firstNode = head;
//        while (head.next!=null){
//            head = head.next;
//        }
//
//        head.next = firstNode;
//    }



    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        if (arr.length == 0) return answer;

        int i = 0;
        int gbMin = Integer.MAX_VALUE;
        int minPos = 0;
        for (int currentValue : arr) {
            answer.add(currentValue);
            int diff = Math.abs(x - currentValue);
            if (diff < gbMin) {
                minPos = i;
                gbMin = diff;
            }
            i++;
        }


        int leftPointer = minPos - (k - 1);
        if (leftPointer < 1) leftPointer = 0;
        int rightPointer = minPos + (k - 1);
        if (rightPointer >= arr.length) rightPointer = arr.length - 1;

        for (int s = leftPointer; s <= rightPointer; s++) {
            smallList.add(Math.abs(arr[s] - x));
        }


        int start = 0;
        int old = start;
        int end = start + (k);
        int globalSum = 0;
        for (int s = 0; s < end; s++) {
            globalSum = globalSum + smallList.get(s);
        }
        int finalstart = start;

        for(int s=1;s+(k-1)<smallList.size();s++){
            int localSum = globalSum + smallList.get(s+(k-1));
            localSum = localSum - smallList.get(old);
            old = s;
            if (localSum < globalSum) {
                globalSum=localSum;
                finalstart = s;
            }

        }


        return (answer.subList(leftPointer+finalstart, leftPointer+finalstart+k));
    }

}
