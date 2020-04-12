import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */

public class Prog71 extends BaseTestClass {
    public static void main(String... args){
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(4);
        obj.push(5);
        obj.push(1);
        obj.push(2);

        println("peek :  " +obj.top());
        println("min :  " +obj.getMin());
        println("pop :  ");
        obj.pop();
        println("peek :  " +obj.top());
        println("min :  " +obj.getMin());
        obj.pop();
        println("min :  " +obj.getMin());


    }


}

class MinStack {

    Stack<Integer> mStack;
    PriorityQueue<Integer> priorityQueue;

    /** initialize your data structure here. */
    public MinStack() {
        mStack = new Stack<>();
        priorityQueue = new PriorityQueue<>();
    }

    public void push(int x) {
        mStack.push(x);
        priorityQueue.add(x);
    }

    public void pop() {
        int popped = mStack.pop();
        if(priorityQueue.size()>0 && popped == priorityQueue.peek()) {
            priorityQueue.poll();
        }
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
