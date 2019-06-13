//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class LRUCache {
//    private int cap ;
//    public List<Integer> list;
//    public Map<Integer,List<Integer>> map;
//    public LRUCache(int capacity) {
//        cap = capacity;
//    }
//
//    public int get(int key) {
//
//        List<Integer> it = map.get(ll);
//        if (it.isEmpty())
//            return -1;
//        return it.get(key);
//    }
//
//    public void put(int key, int value) {
//        List<Map<Integer, Integer>> ll = map.get(key);
//        if(ll.isEmpty())
//            list.remove(ll.get(key));
//        list.add(ll.get(key));
//        if (map.size() > cap){
//
//        }
//    }
//
//}


import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}
public class LRUCache{

    /**
     * 总是在头节点中插入新节点.
     */
    private void addNode(DLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * 摘除一个节点.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * 摘除一个节点,并且将它移动到开头
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * 弹出最尾巴节点
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode>
            cache = new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // cache里面没有
        }

        // cache 命中,挪到开头
        this.moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // 最后一个节点弹出
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            // cache命中,更新cache.
            node.value = value;
            this.moveToHead(node);
        }
    }
}



class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            if (!stack1.isEmpty()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }
        int a = stack2.peek();
        stack2.pop();
        return a;
    }
}



class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = 0;
        int N = 0;
//        while (sc.hasNext()){
          M  = sc.nextInt();
          N  = sc.nextInt();
//        }
        String[] table = {"0123456789ABCDE"};
        String ret = "";
        if (M == 0)
            ret = "0";
        while (M>=0){
            if(M<0){
                M= -M;
                ret+="-";
                ret = table[M%N]+ret;
                M/=N;
            }
        }
        System.out.println(ret);
    }
}