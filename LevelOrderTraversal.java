// TC- O(n) where n is the number of nodes in tree.
// SC - O(n/2) 

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
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

//-------------

//TC - O(n) where n is number od nodes.
//SC - O(
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root == null) return;
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
