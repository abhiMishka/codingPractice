import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//        The cache is initialized with a positive capacity.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3

public class Prog46 extends BaseTestClass {

    public static void main(String... args) {
        LRUCache cache = new LRUCache(3 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(2, 22);


        printEverything(cache);

//        cache.put(4, 1);
//        cache.get(1);
//        cache.get(2);
    }

    private static void printEverything(LRUCache cache) {
        Set<Map.Entry<Integer, Node>> set = cache.lruMap.entrySet();
        Iterator<Map.Entry<Integer, Node>> iterator = (set.iterator());
        while (iterator.hasNext()) {
            Map.Entry<Integer, Node> nodeMap = iterator.next();
            Node node = nodeMap.getValue();
//            print("key : " + node.getKey() + "    node :" + node.toString());
            print("key : " + nodeMap.getKey() + "    value:" + node.val
                    + "    next:" + (node.next == null ? "null" : String.valueOf(node.next.val))
                    + "    prev:" + (node.prev == null ? "null" : String.valueOf(node.prev.val)));
            print("\n");
        }
    }

}

class LRUCache {

    HashMap<Integer, Node> lruMap;
    int capacity;
    Node head;
    Node start;

    public LRUCache(int capacity) {
        lruMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int val = lruMap.get(key).getVal();
        removeNodeAndAddToHead(lruMap.get(key), head, start, val);
        return val;
    }

    /**
     * {
     * <p>
     * if (oldNode == start) {
     * Node tmpStart = start.next;
     * if (start.next == null) {
     * start = nodeToAdd;
     * } else {
     * lruMap.remove(start.key);
     * tmpStart.prev = null;
     * start = tmpStart;
     * }
     * } else if (oldNode == head) {
     * Node tmpHead = head.prev;
     * head.prev = null;
     * tmpHead.next = null;
     * head = tmpHead;
     * }
     * <p>
     * nodeToAdd.prev = head;
     * head.next = nodeToAdd;
     * head = head.next;
     * lruMap.put(key, nodeToAdd);
     * }
     *
     * @param key
     * @param value
     */

    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            Node oldNode = lruMap.get(key);
            Node nodeToAdd = new Node(value, null, null, key);

            lruMap.remove(key);

            if (oldNode == start) {
                Node tmpStart = start.next;
                if (start.next == null) {
                    start = nodeToAdd;
                } else {
                    tmpStart.prev = null;
                    start = tmpStart;
                }
            } else if (oldNode == head) {
                Node tmpHead = head.prev;
                head.prev = null;
                tmpHead.next = null;
                head = tmpHead;
            }else{

            }

            nodeToAdd.prev = head;
            head.next = nodeToAdd;
            head = head.next;
            lruMap.put(key, nodeToAdd);


            removeNodeAndAddToHead(oldNode, head, start, value);
        } else {
            if (lruMap.size() >= capacity) {
                Node nodeToAdd = new Node(value, null, null, key);

                lruMap.remove(start.key);
                //code to remove startNode and add newNode as start
                Node tmpStart = start.next;
                if (start.next == null) {
                    start = nodeToAdd;
                } else {
                    tmpStart.prev = null;
                    start = tmpStart;
                }


                if(capacity!=1) {
                    nodeToAdd.prev = head;
                }
                head.next = nodeToAdd;
                head = head.next;
                lruMap.put(key, nodeToAdd);



            } else {
                Node node = new Node(value, null, null, key);
                if (head == null) {
                    head = node;
                    start = head;
                } else {
                    node.prev = head;
                    head.next = node;
                    head = head.next;
                }
                lruMap.put(key, node);
            }
        }
    }

    private Node addNodeToHead(Node node, Node head, Node start) {
        if (head == null) {
            head = node;
            start = head;
        } else {
            node.prev = head;
            head.next = node;
            head = head.next;
        }

        return node;
    }

    private void removeFirstNodeAndAddNew(Node node, Node head, Node start, int value) {

    }


    public void removeNodeAndAddToHead(Node nodeToRemove, Node head, Node start, int value) {
        if (nodeToRemove == head) {

        } else if (nodeToRemove == start) {

        } else {

        }
    }


}

class Node {
    int val;
    int key;
    public Node prev;
    public Node next;

    public Node(int val, Node prev, Node next, int key) {
        this.val = val;
        this.setPrev(prev);
        this.setNext(next);
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
