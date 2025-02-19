// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only: here i have implemented in bruteteforce approach,first have added level number as key and corresponding nodes as arraylist in hashmap as well as i find the max level then i run the loop to get all list from map in order.

class Solution {
    int maxIndex=0;
    List<List<Integer>> result=new ArrayList<>();
    HashMap<Integer,List<Integer>> sMap=new HashMap<>();
     public List<List<Integer>> levelOrder(TreeNode root) {
         helper(root,0);
        for(int i=0;i<=maxIndex;i++){
            if(sMap.containsKey(i)){
            result.add(sMap.get(i));
            }  
    }
    return result;
   }
   public void helper(TreeNode root,int current){
       if(root == null)return;
         current++;
          maxIndex=Math.max(maxIndex,current);
           if(!sMap.containsKey(current)){
           sMap.put(current,new ArrayList<>());
        }
        sMap.get(current).add(root.val);
       helper(root.left,current);
       
        helper(root.right,current);
   }
   
}








// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only: this is bfs(all) approach,here i am mainting queue with size of levels,
// because here i need to check each levels whether we have left and right elements or not .if queue is not empty just polling those values and adding them into list in parallel if current(poppoed out node from queue) ele contains left and right then adding them into queue ,doing this process repatedly to cover all levels and nodes respectivley.


class Solution {
    List<List<Integer>> result=new ArrayList<>();
    Queue<TreeNode> q=new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
      if(root == null)return result;
      q.add(root);
      while(!q.isEmpty()){
          int size=q.size();
          List<Integer> li=new ArrayList<>();
          for(int i=0;i<size;i++){
              TreeNode node=q.poll();
              li.add(node.val);
              if(node.left != null){
                  q.add(node.left);
              }
               if(node.right != null){
                  q.add(node.right);
              }
          }
          result.add(li);
      }
   return result;
  }
 
  
}



// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only: here i am about avoid extra space and did this in dfs approach.
class Solution {
    List<List<Integer>> result=new  ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
      helper(root,0);
    return result;
  }
 private void helper(TreeNode root,int level){
  if(root == null)return;
  if(level == result.size()){
      result.add(new ArrayList<>());
  }
  result.get(level).add(root.val);
  helper( root.left, level+1);
  helper( root.right, level+1);
 }
  
}