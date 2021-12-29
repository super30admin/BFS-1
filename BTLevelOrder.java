// Time complexity :O(n)
// space complexity :O(n)
// leetcode : success
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>(); 
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null){
             return result;
        }
       
        queue.add(root);
        
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i< level ; i++){
               TreeNode curr = queue.poll();
               list.add(curr.val);
               if(curr.left != null){
                   queue.add(curr.left);
               } 
               if(curr.right != null){
                   queue.add(curr.right);
               }
            }
                result.add(list);
        }
        
        return result;
    }

}
