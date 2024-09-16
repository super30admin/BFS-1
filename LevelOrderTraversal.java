/** 
Problem: Level Order Traversal
Time Complexity: O(n), where n is the number of nodes in the tree (for both DFS and BFS)
Space Complexity : O(n), where n is the number of nodes in the tree, as we use an additional queue.(for BFS). For DFS, it is O(1), since we don't make use of an auxiliary data structure.

Did it run on LeetCode: Yes

Approach 1 : BFS
1. To implement BFS, we make use of a queue.
2. We add the root to the queue, and then we poll it out of the queue, and if it has any children, we add it to the queue.
3. We repeat this process until the queue is not empty. This way, we'd have all the elements in level order traversal.

Approach 2 : DFS
1. In this approach, we use DFS to implement the level order traversal.
2. We also keep track of levels, here, so we know what are the elements at every level.
3. For the result list, we first keep track of the levels. If the number of levels so far is equal to the size of the results list,  we create new list and we keep adding elements to that level, by doing DFS traversal.
*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //Solution 1 : BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                innerList.add(cur.val);                // visit the root
                if (cur.left != null) {
                    q.add(cur.left);              // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.add(cur.right);             // push right child to queue if it is not null
                }
            }
            result.add(innerList);
        }
        return result;
    }
}
        
//Solution 2: DFS
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    public void dfs(TreeNode root, int level) {
        if(root == null) return;
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        
        
    }
    
}