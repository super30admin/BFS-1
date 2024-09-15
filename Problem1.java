// Time Complexity : O(n) as we have to visit all nodes
// Space Complexity : O(n) as we use a queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    /** We traverse from the root node and add each child we encounter to the queue if it isnt null
    To keep track of when we're done with one level of children and have to move to the next, we get the size of queue and
    iterate that many times before adding the new list to output list**/
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root==null) return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                curr=queue.poll();
                temp.add(curr.val);
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }output.add(temp);
        }
        return output;
    }
}