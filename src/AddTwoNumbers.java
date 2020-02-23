import java.util.ArrayList;
import java.util.Collections;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 */

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> la1 = new ArrayList<>();
        ArrayList<ListNode> la2 = new ArrayList<>();

        addNodeToArrayList(l1,la1);
        addNodeToArrayList(l2,la2);

        ListNode result = null;

        int max = Math.max(la1.size(),la2.size());
        int h = 0;
        for (int i = max -1; i > 0; i--) {
            int a = 0;
            int b = 0;

            a = la1.get(i).val;
            b = la2.get(i).val;

            int actualSum = a + b + h;
            if(actualSum > 9 && i > 0){
                String actualSumString = String.valueOf(actualSum);
                actualSum = Integer.valueOf(String.valueOf(actualSumString.charAt(1)));
                h = Integer.valueOf(String.valueOf(actualSumString.charAt(0)));
            }
            else
                h= 0;

            if(result == null)
                 result = new ListNode(actualSum);
            else
                result.next = new ListNode(actualSum);
        }
        return result;

    }

    private static void addNodeToArrayList(ListNode listNode, ArrayList<ListNode> arrayList){
        if(listNode != null) {
            arrayList.add(listNode);
            ListNode next = listNode.next;
            if(next != null)
                addNodeToArrayList(next,arrayList);
        }
    }

    public static void main(String[] args) {
        ListNode top = new ListNode(2);
        ListNode head = top;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;

        ListNode top2 = new ListNode(5);
        ListNode head2 = top2;
        head2.next = new ListNode(6);
        head2 = head2.next;
        head2.next = new ListNode(4);

        addTwoNumbers(top,top2);

    }
}
