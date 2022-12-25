// Time Complexity :O(n)
// Space Complexity :O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

/*
 We will go DFS at each level and maintain a list whose index is going to be the level and keep on adding from left to right
 
 */
class Solution {
    ArrayList<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<List<Integer>>();

        dfsHelper(root,0);

        return list;
    }

    private void dfsHelper(TreeNode root,int level){
        //base case
        if(root == null){
            return;
        }
        //logic
        //check if list exists
        // if not add one
        if(list.size() == level){ // this means the list doesent exist
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        
        //recurse
        //we will be going from left to right
        dfsHelper(root.left,level+1);
        dfsHelper(root.right,level+1);


    }
}