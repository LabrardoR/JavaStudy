package BinarySearchTree;

import java.util.Arrays;

public class HashBuck {

    static class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize; // 存放了多少个数据

    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashBuck(){
        array = new Node[10];
    }
    public void put(int key, int val){

        int index = key % array.length;

        // 遍历index下标的链表 是否存在key,如果存在就更新value,不存在就头插法更新value
        Node cur = array[index];
        while(cur != null){
            if(cur.key == key){
                // 更新value
                cur.val = val;
            }
            cur = cur.next;
        }
        // cur == null 遍历完之后没有找到key
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;

        if(doLoadFactor() > DEFAULT_LOAD_FACTOR){
            // 需要扩容!
            // array = Arrays.copyOf(array,2*array.length); 错!!
            // 扩容后需要重新哈希,原来哈希冲突的位置,现在可能不再冲突

        }
    }

    private void resize(){
        Node[] newArray = new Node[2*array.length];

        // 遍历原来的数组
        for (int i = 0; i < array.length; i++){
            Node cur = array[i];
            // 遍历每个数组元素(链表)
            while(cur != null){
                Node tmp = cur.next;
                int newIndex = cur.key % newArray.length; // 新数组的下标
                // 采用头插法,插入到新数组的 newIndex 下标
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
                cur = tmp;
            }

            array = newArray;
        }
    }

    private float doLoadFactor(){
        return usedSize*1.0f / array.length;
    }

    public int get(int key){
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}
