import java.util.HashMap;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

public class Prog19 {
    public static void main(String[] args) {


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode copyA = headA;
        ListNode copyB = headB;
        while(copyA!=null && copyB!=null){
            copyA = copyA.next;
            copyB = copyB.next;
        }

        if(copyA==null){
            copyA = headB;
            while(copyB!=null){
                copyB = copyB.next;
                copyA = copyA.next;
            }
            copyB = headA;
        }else if(copyB==null){
            copyB = headA;
            while(copyA!=null){
                copyB = copyB.next;
                copyA = copyA.next;
            }
            copyA = headB;
        }

        while(copyA!=null && copyB!=null){
            if(copyA==copyB) return copyA;
            copyA = copyA.next;
            copyB = copyB.next;
        }

        return null;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
