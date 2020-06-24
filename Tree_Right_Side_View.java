/**
 * Time: O(n) n-no of nodes in the tree
 * Space: O(h) height of the tree
 */
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<Integer>();
        if(root == null) return new ArrayList<Integer>();
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode node, int level){
        if(node == null)return;
        if(level == res.size()) res.add(node.val);
        if(node.right != null) dfs(node.right,level+1);
        if(node.left != null) dfs(node.left,level+1);
    }
}

