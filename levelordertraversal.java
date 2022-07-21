/**Time Complexity :
    O(n)
// Space Complexity :
    O(n)
// Did this code successfully run on Leetcode :
     Accepted
// Any problem you faced while coding this :   
    NO
// Your code here along with comments explaining your approach**/



class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> currentLevel=new LinkedList();
            for(int i=0;i<size;i++)
            {
                TreeNode current=queue.remove();
                currentLevel.add(current.val);
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
        
    }
}