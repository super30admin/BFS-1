import java.util.*;
//BSF solution
// Time Complexity: O(n)
//Space Complexity: O(n) // n/2 which is max width of the tree
/*
 * make a queue and store all nodes in it and then get 
 * their childern and add the root to result and repeat the process.
 */

class BinaryLevelOrderTraversal{
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode t = q.poll();
                li.add(t.val);
                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
            }
            result.add(li);
        }
        return result;
    }
}

//DFS solution
// Time Complexity: O(n)
//Space Complexity: O(n) //height of the tree. Those many nodes will be in the stack
/*
 * create a arraylist and travel through the treenode if we find 
 * the level equal to the size of the result then create a new arraylist
 * then add element at that location and call the function for left and right.
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level){
        //base
        if(root == null) return;

        //logic
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}