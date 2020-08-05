//time complexity:O(number of nodes)
//space complexity:O(number of leaf nodes) for bfs
//space  complexity:O(height of tree) for dfs
/*Approach
bfs: keeping each node in the queue and processing it by keeping its left and right child in the queue
we need to keep the size metric for each level because elements in diffrent levels are going to different
lists
dfs: we are going down till the last level and storing the first element of every level in a corresponding 
list and then in similar way going up and exploring other branches of a  node and storing nodes to their 
corresponding level
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal{

    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
        }
    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){return new ArrayList<>();}
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Integer> current = new ArrayList<>();
            int currentSize = queue.size();
            for(int  i = 0 ; i < currentSize; i++)
            {
                TreeNode node = queue.poll();
                current.add(node.val);
                if(node.left != null){queue.offer(node.left);}
                if(node.right != null){queue.offer(node.right);}
            }
            result.add(current);
        }
       return result; 
    }

    //dfs
    List<List<Integer>> result;
    public List<List<Integer>> levelOrderdfs(TreeNode root) {
        result = new ArrayList<>();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root==null)return;
        //logic
        if(level == result.size()){
            List<Integer> curr = new ArrayList<>();
            curr.add(root.val);
            result.add(curr);
        }
        else{
            result.get(level).add(root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
    
        root.left.left= new TreeNode(2);
        root.left.right = new TreeNode(1);

        LevelOrderTraversal obj = new LevelOrderTraversal();
        System.out.println("Using BFS : "+obj.levelOrder(root));
        System.out.println("Using DFS : "+obj.levelOrderdfs(root));
    
    }


}