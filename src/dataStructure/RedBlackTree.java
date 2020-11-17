package dataStructure;

public class RedBlackTree {

    private final int R = 0;
    private final int B = 1;

    private Node root =  null; //红黑树的根结点

    class Node{
        int data;
        int color = R;
        Node left;
        Node right;
        Node parent;

        public Node(int data){
            this.data = data;
        }
    }

    // 插入
    public void insert(Node root, int data){ // root 一定不为空
        if(root.data<data){
            if(root.right==null){
                root.right = new Node(data);
                root.right.parent = root;
            }else{
                insert(root.right,data);
            }
        }else {
            if(root.left==null){
                root.left = new Node(data);
                root.left.parent = root;
            }else {
                insert(root.left,data);
            }
        }
    }


}
