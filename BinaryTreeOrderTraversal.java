//Time Complexity:O(n)
//Space Complexity :O(H)//Height of the tree using recursive stack
//Paypal Interview
//Using DFS:DFS it abondon the parent node and jump to the child .BFS child and parent get process together.But DFS child Dont care

//Given a binary tree starts from root and it returns null if there are no elements.It check from from left to right (level by level order). whenever going for DFS create a list and capture the elements in list.Let me maintain a list and recursive function maintain the size of the list ex.{[3],[9,20],[15,7]}.It should match and return the parent node to child node.Here level variable as maintained local variable becoz going back to recursion and decrease the count.DFS traversal looks like preorder traversal.
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
    List<List<Integer>> result;//Global variable declared 
    public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();//checking root if null then return empty array list.
        
        result = new ArrayList<>();
        //Using DFS
        dfs(root,0);//here 0 is level order
        return result;
    }
    //Using recursive function
    private void dfs(TreeNode root,int level){
        //base
        if(root == null) return;
        //logic
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}