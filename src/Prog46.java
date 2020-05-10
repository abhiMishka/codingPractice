import java.util.*;

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
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(2, 1);
        cache.put(2, 2);
        println("get : "+cache.get(2) );
        cache.put(1, 1);
        cache.put(4, 1);
        println("get : "+cache.get(2) );

//        cache.put(3, 3);
//        cache.put(4, 22);
//
//        println("get : "+cache.get(1) );
//        println("get : "+cache.get(3) );
//        cache.put(2, 22);
//        println("get : "+cache.get(4) );
//
//        cache.put(4, 1);
//        cache.get(1);
//        cache.get(2);
    }


}

class LRUCache {

    HashMap<Integer, Integer> lruMap;
    Deque<Integer> integerDeque;
    int capacity;

    public LRUCache(int capacity) {
        lruMap = new HashMap<>(capacity);
        this.capacity = capacity;
        integerDeque = new LinkedList<>();
    }

    public int get(int key) {
        int val = lruMap.getOrDefault(key,-1);
        if(val!=-1){
            removeNodeAndAddToHead((key));
        }
        return val;
    }

    private void removeNodeAndAddToHead(int value) {
        integerDeque.remove(value);
        integerDeque.addFirst(value);
    }


    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            integerDeque.remove(key);
            lruMap.put(key,value);
            integerDeque.addFirst(key);
        }else{
            if(capacity==lruMap.size()){
                lruMap.remove((integerDeque.getLast()));
                integerDeque.removeLast();

            }
            lruMap.put(key,value);
            integerDeque.addFirst(key);
        }
    }


}

