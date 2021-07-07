//Time Complexity : O(n). n is the number of nodes
//Space Complexity : O(h). h is the height of the tree

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return result;
        }
        //helper function
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root,int level){
        if(root==null){
            return;
        }
        
        List<Integer> temp = new ArrayList<>();
        //if the level and size of the list is same then create a new list and add the node value
        if(result.size() == level){
            temp.add(root.val);
            result.add(temp);
        }
        //otherwise append the node to the existing list
        else{
            result.get(level).add(root.val);
        }
        //contine the same with the root's child nodes
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}