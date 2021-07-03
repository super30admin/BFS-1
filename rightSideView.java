//time complexity O(n)
//space complexity O(n/2)
//APPROACH: BFS

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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int last = -1;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                last = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(last);
        }
        return result;
    }
}


//time complexity O(n) n is no of nodes
//space complexity O(h) h is the height of the tree
//APPROACH: DFS

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
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        //base
        if(root == null) return;

        //logic
        if(level == result.size()) result.add(root.val);
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
