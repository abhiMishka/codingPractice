/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */

public class Prog67 extends BaseTestClass {

    public static void main(String... args){

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;

        while(head!=null && head.next!=null){
            slow = slow.next;
            head = head.next.next;
        }

        new A(){

            @Override
            void method() {

            }
        };

        return slow;
    }
}

abstract class A{
    abstract void method();
}
