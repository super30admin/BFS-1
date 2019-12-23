/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
LeetCode Submitted : YES
Time Complexity : O(N)
Space Complexity : O(N)

The idea is to use Queue Data Structure such that it stores all adjacent nodes in the tree and thus using level order traversal we get the number of nodes at each level.

**/


class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //System.out.println(calcHeight(root));
        if(root == null)
            return output;
        
        //int height = calcHeight(root);
        //int num_nodes = Math.pow(2,height) - 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> t = new ArrayList<>();
            while(size > 0){
                TreeNode temp = queue.poll();
                t.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                
                if(temp.right != null)
                    queue.add(temp.right);
                
                size = size - 1;
                
            }
            output.add(t);
            
        }
        
        /*for(int i = 1; i <= height; i++){
            List<Integer> temp = new ArrayList<>();
            addOutput(root, i,temp);
            output.add(temp);
        }*/
        
        return output;
        
    }
    
    private void addOutput(TreeNode root, int i,List<Integer> temp ){
        if(root == null)
            return;
        if(i == 1){
            System.out.println(root.val);
            temp.add(root.val);
            return; 
            
        }
            // temp.add(root.val);
        
        addOutput(root.left,i-1,temp);
        addOutput(root.right,i-1,temp);
        
        
    }
    
    private int calcHeight(TreeNode root){
        if(root == null)
            return 0;
        
        //if(root.left == null || root.right == null)
         //   return 0;
        
        int left  =  1 + calcHeight(root.left);
        int right =  1 + calcHeight(root.right); 
        
        if(left > right)
            return left;
        return right;
    }
}
