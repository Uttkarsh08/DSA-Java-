package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Info{
        Node node;
        int hd;
        public Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        //level order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0; int max = 0;
        
        q.add(new Info(root, 0));

        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur != null){
                if(!map.containsKey(cur.hd)){
                    map.put(cur.hd, cur.node);
                }
                
                if(cur.node.left != null){
                    q.add(new Info(cur.node.left, cur.hd-1));
                    min = Math.min(min, cur.hd-1);
                }
                if(cur.node.right != null){
                    q.add(new Info(cur.node.right, cur.hd+1));
                    max = Math.max(cur.hd+1, max);
                }
            }
        }
    
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
            
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}