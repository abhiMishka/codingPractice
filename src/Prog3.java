import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prog3 extends BaseTestClass {
    public static void main(String... args) {
        ListNode top = new ListNode(5);
//        ListNode head = top;
//        head.next = new ListNode(4);
//        head = head.next;

        ListNode top2 = new ListNode(5);
//        ListNode head2 = top2;
//        head2.next = new ListNode(6);
//        head2 = head2.next;
//        head2.next = new ListNode(4);

//        while(top!=null){
//            print(top.val +" ");
//            top = top.next;
//        }
//
//        print("\n");
//        while(top2!=null){
//            print(top2.val +" ");
//            top2 = top2.next;
//        }

        ListNode ans = addTwoNumbers2(top, top2);
        while (ans!=null){
            print(ans.val+" ");
            ans = ans.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode headAns;

        ListNode l1Head = l1;
        ListNode l2Head = l2;

        int l1Len = 0;
        int l2Len = 0;
        while (l1 != null) {
            l1Len++;
            l1 = l1.next;
        }
        l1 = l1Head;

        while (l2 != null) {
            l2Len++;
            l2 = l2.next;
        }

        l2 = l2Head;

        if (l1Len < l2Len) {
            int diff = l2Len - l1Len;
            int i = 0;

            while(l1Head.next!=null){
                print(l1Head.val +" ");
                l1Head = l1Head.next;
            }
            l1=l1Head;
            while (i < diff ) {
                l1Head.next = new ListNode(0);
                l1Head = l1Head.next;
                i++;
            }
        }

        l1Head = l1;



        if (l1Len > l2Len) {
            int diff = l1Len - l2Len;
            int i = 0;

            while(l2Head.next!=null){
                print(l2Head.val +" ");
                l2Head = l2Head.next;
            }
            l2=l2Head;

            while (i < diff ) {
                l2Head.next = new ListNode(0);
                l2Head = l2Head.next;
                i++;
            }
        }

        l2Head = l2;



        int sum = l1Head.val + l2Head.val;
        int carry = 0;
        if (sum >= 10 && sum <= 19) {
            carry = 1;
            sum = sum % 10;
        }else if(sum >=20){
            carry = 2;
            sum = sum % 20;
        }

        if(l1Head.next==null){
            if(carry==0) {
                headAns = new ListNode(l1Head.val + l2Head.val);
            }else{
                headAns = new ListNode(sum);
                headAns.next = new ListNode(carry);
            }
        }else{
            headAns = new ListNode(sum);
        }
//        print(headAns.val+" ");
        ListNode headAnsCopy = headAns;
        l1Head = l1Head.next;
        l2Head = l2Head.next;

        while (l1Head != null) {
            sum = l1Head.val + l2Head.val + carry;
            if (sum >= 10 && sum <= 19) {
                carry = 1;
                sum = sum % 10;
            }else if(sum >=20){
                carry = 2;
                sum = sum % 20;
            }else{
                if(l1Head.next!=null) {
                    carry = 0;
                }
            }

            if(l1Head.next==null){
                if(carry==0) {
                    headAns = new ListNode(l1Head.val + l2Head.val);
                }else{
                    headAns = new ListNode(sum);
                    headAns.next = new ListNode(carry);
                }
            }else{
                headAns.next = new ListNode(sum);
            }
//            print(headAns.next.val+" ");
            headAns = headAns.next;
            l1Head = l1Head.next;
            l2Head = l2Head.next;
        }

//        print("\n");
//        while (headAnsCopy != null) {
//            print(headAnsCopy.val + " ");
//            headAnsCopy = headAnsCopy.next;
//        }


        return headAnsCopy;


    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int sum = 0;
        int sumCopy = 0;
        int val1 =0;
        int val2 = 0;
        int carry = 0;
        ListNode topNode = null;
        ListNode copyNode = new ListNode(-1);
        ListNode ansNode = null;
        int i = 0;
        while (l1 != null || l2 != null) {
            val1=0;val2=0;
            if(l1!=null) val1 = l1.val;
            if(l2!=null) val2 = l2.val;

            sum = val1 + val2 + carry;
            sumCopy = sum;
            if (sum >= 10 && sum <= 19) {
                carry = 1;
                sum = sum % 10;
            } else if (sum >= 20) {
                carry = 2;
                sum = sum % 20;
            }else{
                carry = 0;
            }

            ListNode node = new ListNode(sum);
            if(ansNode==null){
                ansNode = node;
                copyNode = ansNode;
            }else{
                ansNode.next = node;
                ansNode = ansNode.next;
            }

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;

        }

        if(sumCopy >= 10){
            ansNode.next = new ListNode(carry);
        }

        return copyNode;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

