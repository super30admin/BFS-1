import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Bst {
    Node root = new Node(100, new Node(50, new Node(20, null, null), new Node(80, null, null)), new Node(150, new Node(120, new Node(110, null, null), null), null));
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    public Bst() {

    } 

    public void traverse() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<Integer>();
            int i;
            for (i = 0; i < size; i++)
            {
                Node v = q.poll();
                ans.add(v.val);
                if (v.left != null) {
                    q.add(v.left);
                }
                if (v.right != null) {
                    q.add(v.right);
                }
            }
            arr.add(ans);
        }
        System.out.println(arr);        
    }
}   

public class Bfs
{
    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.traverse();
    }     
}

