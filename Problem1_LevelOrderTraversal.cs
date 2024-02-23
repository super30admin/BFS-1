// Time Complexity : O(n)
// Space Complexity : O(n)
// Approach : Breadth First Search
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        List<IList<int>> result = new List<IList<int>>();
        if(root == null) return result;
        //Queue to store nodes to process
        Queue<TreeNode> bfs = new Queue<TreeNode>();
        int level = 0; //start with level 0
        bfs.Enqueue(root);
        while(bfs.Count > 0) { //While queue is not empty
            int size = bfs.Count; //get the count of nodes to process for current level -> 'level'
            for(int i = 0; i < size; i++){
                TreeNode curr = bfs.Dequeue(); //Pop the node to be processed from queue
                if(curr.left != null) {
                    bfs.Enqueue(curr.left); //Add left child to the queue to process if not null
                }
                if(curr.right != null) {
                    bfs.Enqueue(curr.right); //Add right child to the queue to process if not null
                }
                //Add the processed node's val to the result under index of level
                if(result.Count == level) {
                    List<int> list = new List<int>{curr.val};
                    result.Add(list);
                }
                else {
                    result[level].Add(curr.val);
                }
            }
            level++; //Process next level's nodes if queue is not empty.
        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Approach : Depth First Search

public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> LevelOrder(TreeNode root) {
        result = new List<IList<int>>();
        LevelOrderDfs(root, 0);
        return result;
    }

    private void LevelOrderDfs(TreeNode root, int level) {
        if(root == null) return;

        //Initialization of new list should always be preorder
        if(result.Count == level) {
            //Add new list in result for nodes at 'level'  
            result.Add(new List<int>());
        }
        result[level].Add(root.val);

        //Traverse Left
        LevelOrderDfs(root.left, level + 1);
        //Traverse Right
        LevelOrderDfs(root.right, level + 1);
    }
}