package BinarySearchTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("sunny");
        set.add("hello");
        set.add("the");

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
    public static void main_map(String[] args) {
        Map<String, Integer> map = new TreeMap<>(); //  查找的时间复杂度 O(N)
        // 元素存储
        map.put("sunny",3);
        map.put("the",5);
        // 元素获取
        // 通过key获取val值
        Integer val = map.get("the");
        Integer val2 = map.getOrDefault("the2",-1);

        Set<String> set = map.keySet();
        System.out.println(set);

        Map<String, Integer> map2 = new HashMap<>();//  查找的时间复杂度 O(1)
    }
    public static void main1(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] arr = {5,12,3,2,11,15};
        for(int i = 0; i < arr.length; i++){
            binarySearchTree.insert(arr[i]);
        }
        binarySearchTree.traverse(binarySearchTree.root);
    }

}
