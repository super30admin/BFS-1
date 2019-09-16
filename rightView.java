/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Space Complexity :O(N)
//Time Complexity :O(N)
//We have used the BFS method to traverse the tree and we have added the last node in the iteration which corresponds to the rightmost element of the binary tree .
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightList = new ArrayList<>();

        //base case
        if(root == null)
            return rightList;

        Queue<TreeNode> queue = new LinkedList<>();
        //we use Queue for the BFS .
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i< size;i++){
                TreeNode current = queue.remove();
                if( i == size-1){
                    rightList.add(current.val);
                }

                if(current.left !=null)
                    queue.add(current.left);

                if(current.right !=null)
                    queue.add(current.right);
            }
        }
        return rightList;
    }
}