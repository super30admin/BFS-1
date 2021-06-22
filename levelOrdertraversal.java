// Time Complexity : O(N) where N=number of nodes in the tree
// Space Complexity : O(N) where N=number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> levelOrder  = new ArrayList<List<Integer>>();
    List<TreeNode> queue1  = new ArrayList<TreeNode>();
    List<TreeNode> queue2  = new ArrayList<TreeNode>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levelOrder;
        ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        temp.add(root);
        bfs(temp);
        
        return levelOrder;
    }
    
    public void bfs(List<TreeNode> level) {
        List<Integer> levelValues = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        int size = level.size();
        for (int i = 0; i < size; i++) {
        TreeNode currNode = level.remove(0);
            if(currNode!=null) {
                levelValues.add(currNode.val);
                if(currNode.left!=null)
                    nextLevel.add(currNode.left);

                if(currNode.right!=null)
                    nextLevel.add(currNode.right);
            }
            
        } 
        levelOrder.add(levelValues);
        ArrayList listCopy = new ArrayList(nextLevel);
        if(listCopy.size()>0)
            bfs(listCopy);
    }
}
