package BinarySearchTree;

public class BinarySearchTree {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode root;

    public boolean search(int key){
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < key){
                cur = cur.left;
            }else if(cur.val > key){
                cur = cur.right;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean insert(int val){
        if(root == null){
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null){
            parent = cur;
            if(cur.val < val){
                cur = cur.right;
            }else if(cur.val > val){
                cur = cur.left;
            }else{
                return false;
            }
        }
        TreeNode node = new TreeNode(val);
        if(parent.val > val){
            // 插入到左边
            parent.left = node;
        }else{
            parent.right = node;
        }
        return true;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }
    public void remove(int key){
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null){
            if(cur.val < key){
                parent = cur;
                cur = cur.left;
            }else if(cur.val > key){
                parent = cur;
                cur = cur.right;
            }else{
                // 开始删除
                removeNode(cur, parent);
            }
        }
    }
    private void removeNode(TreeNode cur, TreeNode parent){
        if(cur.left == null){ // cur 左边为空
            if(cur == root){
                root = cur.right;
            }else if(cur == parent.left){
                parent.left = cur.right;
            }else if(cur == parent.right){
                parent.right = cur.right;
            }

        }else if(cur.right == null){  // 右边为空
            if(cur == root){
                root = cur.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else if(cur == parent.right){
                parent.right = cur.left;
            }
        }else{ // 左右都不为空
            TreeNode targetParent = cur;
            TreeNode target = cur.right;
            while(target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            // 删除target
            if(targetParent.left == target){
                targetParent.left = target.right;
            }else{
                targetParent.right = target.right;
            }
        }
    }

}
