// Time Complexity : The time complexity is O(n) where n is the number of nodes
// Space Complexity : The space complexity is O(l) where l is the maximum number of nodes in a level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if(root == null){
            return output;
        }

        // Queue for traversing level by level
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size=q.size();

        List<Integer> temp = new LinkedList<>();

        while(!q.isEmpty()){

            TreeNode node = q.poll();
            size--;
            temp.add(node.val);

            if(node.left!=null){
                q.offer(node.left);
            }

            if(node.right!=null){
                q.offer(node.right);
            }

            // When size is 0, that means a level has completed
            if(size==0){
                output.add(new ArrayList<>(temp));
                size=q.size();
                temp = new ArrayList<>();
            }
        }

        return output;
    }
}