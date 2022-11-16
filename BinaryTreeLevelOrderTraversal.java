

// TC : O(n)
// SC : O(n)


package S30_Codes.BFS_1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
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

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> curQueue = new LinkedList<>();

        if(root != null)
            curQueue.add(root);

        while( !curQueue.isEmpty() ){
            Queue<TreeNode> nextQueue = new LinkedList<>();
            ArrayList<Integer> al = new ArrayList<>();

            while(!curQueue.isEmpty()){
                TreeNode node = curQueue.poll();
                al.add(node.val);

                if(node.left != null)
                    nextQueue.add(node.left);
                if(node.right != null)
                    nextQueue.add(node.right);
            }

            ans.add(al);
            curQueue = nextQueue;
        }

        return ans;
    }
}