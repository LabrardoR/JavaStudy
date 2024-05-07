package linklist;

class SingleList{
    static class LNode{
        public int val;
        public LNode next;

        public LNode (){
            this.val = -1;
            this.next = null;
        }
        public LNode(int val){
            this.val = val;
        }
    }
    public LNode head;// 头结点
    public int size = 0;// 有多少个元素
    public void createList(){

    }
    // 头插法
    public void addFirst(int data){
        LNode node = new LNode(data);
        if(this.head == null){
            // 新创建的节点为第一个节点
            this.head = node;
        }
        else{
            node.next = head.next;
            head = node;
        }
        size++;
    }

    public void addLast(int data){
        LNode node = new LNode(data);
        if(head == null){
            head = node;
        }else{
            LNode cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
    }

    public LNode searchPrev(int index){
        LNode cur = head;
        int count = 0;
        while (count != index - 1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public void addIndex(int index, int data){
        if (index < 0 || index > size){
            System.out.println("插入位置非法!");
            return;
        }
        if(index == 0){
            addFirst(data);
        }
        if(index == size){
            addLast(data);
        }

        LNode cur = searchPrev(index);
        LNode node = new LNode(data);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void remove(int val){
        if(size == 0){
            System.out.println("链表为空,无法删除!");
            return;
        }
        if(this.head.val == val){
            this.head = this.head.next;

        }
        else{
            
        }
    }

}



public class Demo1 {
    public static void main(String[] args) {

    }
}
