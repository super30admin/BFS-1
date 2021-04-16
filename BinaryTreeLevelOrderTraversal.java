// Time Complexity : O(N)
// Space Complexity : BFS-> O(N) DFS -> O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    // List<List<Integer>> result = new ArrayList<>();
    // private void helper(TreeNode root,int level){
    //     if(root == null) return;
    //     if(result.size() == level){
    //         result.add(new ArrayList<Integer>());
    //     }
    //     result.get(level).add(root.val);
    //     helper(root.left,level+1);
    //     helper(root.right,level+1);
    // }
    public List<List<Integer>> levelOrder(TreeNode root) {
        // helper(root,0);
        // return result;
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}
