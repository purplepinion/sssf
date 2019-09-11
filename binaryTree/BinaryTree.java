package com.chrisz.algorithm.example.binaryTree;

public class BinaryTree{

    Node root;

    public static void main(String[] args) {

        int[] test = {1,2,3,4,5,6,-1,8,-1,10};

        BinaryTree binaryTree = new BinaryTree(test);

        binaryTree.preOrder();

        binaryTree.inOrder();

        binaryTree.postOrder();

        System.out.println(binaryTree.searchNode(5).left.val);//10

        binaryTree.delNode(5);

        binaryTree.preOrder();
    }

    BinaryTree(Node root){
        this.root = root;
    }

    /**
     * todo: -1表示null
     * @param values
     */
    BinaryTree(int[] values){

        int len = values.length;

        if(values[0]==-1){
            root = null;
        }

        root = new Node(values[0]);
        createBinaryTree(values,0,root);

    }

    public void createBinaryTree(int[] values, int i, Node root){

        int len = values.length;

        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;

        if(leftIndex<len){
            if(values[leftIndex]!=-1){
                root.left = new Node(values[leftIndex]);
                createBinaryTree(values,leftIndex,root.left);
            }
        }

        if(rightIndex<len){
            if(values[rightIndex]!=-1){
                root.right = new Node(values[rightIndex]);
                createBinaryTree(values,rightIndex,root.right);
            }
        }
    }

    public void preOrder(){
        System.out.println("前序遍历：");
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node root){
        if(root==null){
            return;
        }
        visit(root);
        preOrder(root.left);
        preOrder(root.right);
    }


    public void inOrder(){
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node root){
        if(root==null){
            return;
        }

        inOrder(root.left);
        visit(root);
        inOrder(root.right);
    }

    public void postOrder(){
        System.out.println("后序遍历：");
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node root){
        if(root==null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        visit(root);
    }

    public Node searchNode(int val){

        return searchNode(root,val);
    }

    private Node searchNode(Node root, int val){
        if(val==-1 || root== null){
            return null;
        }

        if(root.val==val){
            return root;
        }

        Node left = searchNode(root.left,val);
        Node right = searchNode(root.right,val);

        if(left!=null) {
            return  left;
        }

        if(right!=null){
            return right;
        }
        return null;
    }

    public void delNode(int val){
        if(root!=null&&root.val==val){
            root = null;
            return;
        }
        delNode(root,val);

    }

    private void delNode(Node root, int val){

        if(root.left!=null&&root.left.val==val){
            root.left = null;
            return;
        }

        if(root.right!=null&&root.right.val==val){
            root.right = null;
            return;
        }

        if(root.left!=null){
            delNode(root.left,val);
        }

        if(root.right!=null){
            delNode(root.right,val);
        }

    }



    public void  visit(Node node){
        System.out.print(node.val + ",");
    }
}

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}