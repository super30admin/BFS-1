// Time Complexity : O(N)N=number of elements in tree . 
// Space Complexity : O(N) because we use extra data structure the queue and it is max diameter or width . worst case is full complete tree so O(n/2)=> O(n)
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the brute force uses the level order traversal and take the last element of level and add it to output;
//Success
//Details 
//Runtime: 1 ms, faster than 76.78% of Java online submissions for Binary Tree Right Side View.
//Memory Usage: 39.7 MB, less than 5.88% of Java online submissions for Binary Tree Right Side View.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size= q.size();
            for (int i=0;i<size;i++){
                TreeNode node=q.poll();
                if (i==(size-1))
                    result.add(node.val);
                if (node.left!=null)
                    q.add(node.left);
                if (node.right!=null)
                    q.add(node.right);
            }
        }
        return result;
    }
    
   
}