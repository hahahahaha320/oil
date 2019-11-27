package com.oolong.oil.algori.tree;

public class BST {
    private Node root;
    private boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //我们以某个元素为研究对象，
    //假设我们已经知道了对一个元素的约束:处于(min,max)之间，
    //那么对这个元素的左子节点的约束为(min,x.key),对右子节点的约束为(x.key,max)
    private boolean isBST(Node x, int min, int max) {
        if (x == null) return true;
        if(x.key < min || x.key > max) return false;
        System.out.println(String.format("test key:%d,min:%d,max:%d",x.key,min,max));
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }



    private static class Node {
        private int key;           // sorted by key
        private Node left, right;  // left and right subtrees


        public Node(int key) {
            this.key = key;
        }
        public Node(int key,Node left,Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
        public Node(int key,int left,int right) {
            this.key = key;
            this.left = new Node(left);
            this.right = new Node(right);
        }
    }





    public static void main(String[] args) {

        Node nodeLeft = new Node(35,32,38);
        Node nodeRight = new Node(45,42,48);
        Node node1 = new Node(40,nodeLeft,nodeRight);

        nodeLeft = new Node(55,52,58);
        nodeRight = new Node(65,62,68);
        Node node2 = new Node(60,nodeLeft,nodeRight);

        BST test = new BST();
        test.root = new Node(50,node1,node2);;

        System.out.println(test.isBST());
    }

}

