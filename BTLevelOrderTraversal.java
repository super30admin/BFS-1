
//Time Complexity- O(n)
//Space complexity- O(n)
// Ran successfully on leetcode


class Solution {
    
 List<List<Integer>> result ;
 public List<List<Integer>> levelOrder(TreeNode root) {
     
     if(root== null) return new ArrayList<>();
     
     result= new ArrayList<>();
     Queue<TreeNode> q = new LinkedList<>();
     q.add(root);
     
     while(!q.isEmpty()){
         
         int size= q.size();
         List<Integer> list= new ArrayList<>();
         for(int i=0; i< size; i++){
             TreeNode curr= q.poll();
             
             list.add(curr.val);
             
             if(curr.left!= null){
                 q.add(curr.left);
             }
             if(curr.right!=null){
                 q.add(curr.right);
             }
         }
         result.add(list);
     }
     return result;
 }
}