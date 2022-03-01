// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(n) where n is number of nodes in tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach : Iterative lvel order traversal using queue, add the root to queue and while q is not empty get the size of queue and
//remove the elements , add the children of removed elements back in queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i<size; i++){
                TreeNode curr  = q.poll();
                if(curr != null){
                    temp.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }

            if(temp.size() > 0){
                res.add(temp);
            }
        }

        return res;
    }
}
