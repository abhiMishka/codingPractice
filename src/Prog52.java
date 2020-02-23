/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 */
public class Prog52 extends BaseTestClass {

    public static void main(String... args){

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpHead = head;
        ListNode p1 = head;
        ListNode p2 = head;

        while (n>0){
            p2 = p2.next;
            n--;
        }

        if(p2!=null){
            while (p2.next!=null){
                p1 = p1.next;
                p2 = p2.next;
            }
            if(p1!=null){
                if(p1.next!=null){
                    p1.next = p1.next.next;
                }else{
                    tmpHead = p1;
                    p1.next = null;
                }
            }
        }else{
            tmpHead = p1.next;
            p1 = p1.next;
        }

        return tmpHead;
    }
}
