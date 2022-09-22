// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Do BFS, and add values at each level and the values to result at end of each level
*/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue= new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int qs= queue.size();
            ArrayList<Integer> values= new ArrayList<>();
            for(int i=0;i<qs;i++){
                TreeNode curr= queue.poll();
                values.add(curr.val);
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            result.add(values);
        }

        return result;
    }
}
