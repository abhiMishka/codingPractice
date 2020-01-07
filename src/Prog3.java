import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prog3 {
    public static void main(String... args){
        int[] arr = new int[]{1};

        List<ListNode> listNode1 = new ArrayList<>();
        List<ListNode> listNode2 = new ArrayList<>();

        for (int i =0;i<1; i++){
            ListNode l1 = new ListNode(5);
            ListNode l2 = new ListNode(5);
            listNode1.add(l1);
            listNode2.add(l2);
        }

        for(int i =0;i<listNode1.size(); i++){
            if(i<listNode1.size()-1) {
                listNode1.get(i).next = listNode1.get(i + 1);
            }else {
                listNode1.get(i).next = null;
            }
        }

        for(int i =0;i<listNode2.size(); i++){
            if(i<listNode2.size()-1) {
                listNode2.get(i).next = listNode2.get(i + 1);
            }else {
                listNode2.get(i).next = null;
            }
        }

        ListNode node = listNode2.get(0);
        while (node.next!=null){
            System.out.print("node  : " +node.val);
            node = node.next;
        }

        System.out.print(" node  : " +node.val +"\n");

        node = listNode1.get(0);
        while (node.next!=null){
            System.out.print("node  : " +node.val);
            node = node.next;
        }

        System.out.print(" node  : " +node.val +"\n");


        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = l2;
        l2.next = null;

        ListNode answer = addTwoNumbers(listNode1.get(0),listNode2.get(0));

        node = answer;
        while (node.next!=null){
            System.out.print("node  : " +node.val);
            node = node.next;
        }

//        System.out.print(" node  : " +node.val);

//        for (int i =0;i<arr.length; i++){
//            System.out.print(arr[i]+",");
//        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int pow = 0;
        int sum1 = 0;
        int finalSum;

        while(l1.next!=null){
            sum1 = (int) (sum1+(l1.val*Math.pow(10,pow)));
            pow++;
            l1 = l1.next;
        }
        sum1 = (int) (sum1+(l1.val*Math.pow(10,pow)));

        finalSum = sum1;

        System.out.println("finalSum : " +finalSum);


        pow = 0;
        sum1 = 0;

        while(l2.next!=null){
            sum1 = (int) (sum1+(l2.val*Math.pow(10,pow)));
            pow++;
            l2 = l2.next;
        }

        sum1 = (int) (sum1+(l2.val*Math.pow(10,pow)));

        finalSum = finalSum+sum1;

        List<ListNode> finalNodeList = new ArrayList<>();
        if(finalSum<10){
            ListNode node = new ListNode(finalSum);
            finalNodeList.add(node);
        }else {
            while (finalSum >= 10) {
                int lastDig = (int) (finalSum % 10);
                ListNode node = new ListNode(lastDig);

                finalNodeList.add(node);
                finalSum = (finalSum - lastDig) / 10;
                if (finalSum < 10) {
                    node = new ListNode(finalSum);
                    finalNodeList.add(node);
                    break;
                }

            }
        }

        for(int i =0;i<finalNodeList.size(); i++){
            if(i<finalNodeList.size()-1) {
                finalNodeList.get(i).next = finalNodeList.get(i + 1);
            }
        }

        System.out.println("finalNodeList : " +finalNodeList.get(0).val +" , " +finalNodeList.get(1).val);


        if(finalNodeList.size()!=0) {
            return finalNodeList.get(0);
        }else{
            return null;
        }

    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

