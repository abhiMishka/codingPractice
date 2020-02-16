import java.util.*;

public class Prog48 extends BaseTestClass {

    public static void main(String... args) {
//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        myStack.push(4);
//        println(String.valueOf(myStack.top()));;
//        println(String.valueOf(myStack.pop()));;
//        myStack.push(5);
//        println(String.valueOf(myStack.pop()));;
//        println(Arrays.toString(myStack.q1.toArray()));

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        myQueue.pop();

        myQueue.push(5);

        myQueue.pop();
        myQueue.pop();
        myQueue.pop();


//        println(String.valueOf(myQueue.peek()));

    }

}


//class MyStack {
//
//    Queue<Integer> q1;
//    Queue<Integer> q2;
//
//    /** Initialize your data structure here. */
//    public MyStack() {
//        q1 = new LinkedList<>();
//        q2 = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        q1.add(x);
////        if(q1.size()>1){
////            q2.add(q1.remove());
////        }
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        while (q1.size()>1){
//            q2.add(q1.remove());
//        }
//        return q1.remove();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return q1.peek();
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return q1.isEmpty()&&q2.isEmpty();
//    }
//}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if(!stack2.isEmpty()){
            int  k = stack2.pop();
            System.out.println(k);
            return k;
        }
        while (stack1.size() > 0) {
            stack2.add(stack1.pop());
        }
        int a = stack2.pop();
        System.out.println(a);
        return a;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(stack2.isEmpty()) return stack1.firstElement();
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
