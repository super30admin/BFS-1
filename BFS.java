/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time Complexity : O(N)
//Space Complexity : O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //declare the resultant list
        List<List<Integer>> result = new ArrayList<>();

        //base case
        if(root == null){
            return result;
        }

        //We use Queue for the BFS
        Queue<TreeNode> queue = new LinkedList<>();

        // add the element
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> currentlist = new ArrayList<>();
            for(int i =0;i<size;i++){
                //we remove the element
                TreeNode current = queue.remove();
                currentlist.add(current.val);
                //we check if the element being removed has a Left or Right child , in case it is there we add them
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            result.add(currentlist);

        }
        return result;
    }
}

