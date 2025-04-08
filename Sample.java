// Time Complexity : O(N) N is the number of TreeNodes
// Space Complexity : O(K) K = no of leaf nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Using BFS we add the nodes to the queue and explore the levels

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();


            for(int i=0 ; i< size; i++){
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            res.add(temp);

        }
        return res;
    }
}