/**Leetcode Question - 102 - Binary Tree Level Order Traversal */
/**Algorithm - BFS
 * Create a queue and push the root in it
 * Now check while the queue is not empty, pop the first element
 * Check if the popped element has left and right child and add them to the queue
 * Add the results and return the results list
 */
/**TC - O(N)
 * SC - O((N/2) + 1 ) = O(N)
 */
public class BinaryTreeLevelOrderTraversal {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> temp = new ArrayList<>();
                for(int i = 0; i< size; i++){
                    TreeNode curr = q.poll();
                    temp.add(curr.val);
                    if(curr.left!= null){
                        q.add(curr.left);
                    }
                    if(curr.right!= null){
                        q.add(curr.right);
                    }
                }
                res.add(temp);
            }
            return res;
        }
    }
}
/**Algorithm - DFS
 * Pass the current root and the level to the dfs function recursively
 * If the current size of the res and the lvl are equal, add a new arraylist
 * else append to the older arraylist
 */
/**TC -O(N)
 * SC -O(H) - height of the tree == O(N) if the tree is skewed
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root, int lvl){
        //base
        if(root == null){
            return;
        }
        //logic
        if(res.size() == lvl){
            res.add(new ArrayList<>());
        }
        res.get(lvl).add(root.val);
        dfs(root.left, lvl+1);
        dfs(root.right, lvl +1);
    }
}