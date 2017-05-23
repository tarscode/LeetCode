import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: LRUCache
 * 【作者】: liuyang
 * 【时间】: 17/4/29 下午2:41
 * 【题目】: LRU Cache
 * 【内容】: 设计一个数据结构实现LRU缓存
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】: 能够实现所有操作的时间复杂度都是O(1)的么？
 * 【思路】:
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
    public static void main(String[] args) {
        LRUCache t = new LRUCache(2);
        System.out.println();

        LinkedHashMap<Integer, Integer> tmp = new LinkedHashMap<>();
        tmp.put(1, 1);
        tmp.put(2, 2);
        System.out.println(t);
    }
}
/*
public class LRUCache {

    private HashMap<Integer, Integer> map;

    private LinkedList<Integer> list;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsValue(key)) {
            update(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.containsKey(key)) {
            update(key);
        } else if (list.size() < capacity) {
            list.addFirst(key);
        } else {
            list.pollLast();
            list.addFirst(key);
        }
    }

    public void update(int key) {
        list.remove(key);
        list.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache t = new LRUCache(2);
        System.out.println();

        LinkedHashMap<Integer, Integer> tmp = new LinkedHashMap<>();
        tmp.put(1, 1);
        tmp.put(2, 2);
        System.out.println(t);
    }
}
*/