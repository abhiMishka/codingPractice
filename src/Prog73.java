import java.util.ArrayList;
import java.util.List;

public class Prog73 extends BaseTestClass {
    public static void main(String... args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode();
        ListNode mergedHead = new ListNode();
        mergedHead = mergedList;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null) {
//            for (ListNode node :
//                    listNodes) {
            if (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    mergedList.next = p1;
                    p1 = p1.next;
                    mergedList = mergedList.next;

                } else {
                    mergedList.next = p2;
                    p2 = p2.next;
                    mergedList = mergedList.next;
                }
            } else if (p1 == null) {
                while (p2 != null) {
                    mergedList.next = p2;
                    p2 = p2.next;
                    mergedList = mergedList.next;
                }
            } else {
                while (p1 != null) {
                    mergedList.next = p1;
                    p1 = p1.next;
                    mergedList = mergedList.next;
                }
            }
        }

        return mergedHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode mergedList = mergeTwoLists(lists[0],lists[1]);

        for(int i=2;i<lists.length;i++){
            mergedList = mergeTwoLists(mergedList,lists[i]);
        }

        return mergedList;
    }
}
