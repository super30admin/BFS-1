// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class LevelOrder {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level){
        if(root == null) return;

        //create new array for new level
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        //add current node to its level
        result.get(level).add(root.val);

        //dfs left and right
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}