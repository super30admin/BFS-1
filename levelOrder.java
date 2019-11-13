/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* 102. Binary Tree Level Order Traversal
Time Complexity: O(n) since each node is processed exactly once
Space Complexity: O(n) to keep the output structure which keeps 'n' node values
Approach: Iterative

Initialize the queue with a root and start from level number 0.
while the queue is not empty => calculate the queue size. Iterate over the size number of times, pop out these elements from the queue.
add them to the current level, next push their child nodes into the queue for the next level
*/

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>(); // [] for each level
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll(); // 3 //next pop out 3's children
                temp.add(cur.val);
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            result.add(temp);  //[3] for each level
        }
        return result;
    }
}

/* 102. Binary Tree Level Order Traversal

Time Complexity: O(n) since each node is processed exactly once
Space Complexity: O(n) to keep the output structure which keeps 'n' node values
Approach: Recursive Approach

Do the same thing level by level recursion
*/


class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;

        bfs(root, 0); // level 0
        return result;
    }

    private void bfs(TreeNode root, int level){
        if(root == null)
            return;

        if(result.size() == level)
            result.add(new ArrayList<Integer>());

        // get that temp list inside the result list for each level and add to that
        result.get(level).add(root.val);
        bfs(root.left, level+1);
        bfs(root.right, level+1);
    }
}