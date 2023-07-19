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
//Time Complexity = O(N)
//Space Complexity = O(N) for the result
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //base
        if(root==null)return result;

        //logic
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> lst = new ArrayList<>();
            //putting each lever in a arrayList
            for(int i =0; i< size ;i++){
                TreeNode curr = q.poll();
                //adding children
                if(curr.left !=null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);

                lst.add(curr.val);
            }
            //Adding level ArrayList to result list
            result.add(lst);
        }
        return result;
    }
}