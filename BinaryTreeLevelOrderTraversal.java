// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> list= new ArrayList<>();
        if(root==null) return list;

        queue.offer(root);
        
        while(!queue.isEmpty()){
            int queueSize= queue.size();
            List<Integer> subList= new ArrayList<>();
            for(int i=0; i<queueSize; i++){
                TreeNode current=queue.poll();
                subList.add(current.val);  

                if(current.left!=null){
                    queue.offer(current.left);
                }  

                if(current.right!=null){
                    queue.offer(current.right);
                } 

            }
            list.add(subList);   
        }
        return list;
    }
}