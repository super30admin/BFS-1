//Time complexity:-O(N);
//Space complexity:-0(1);
// Did it run on leetcode?:-yes
//What problems did you face?:- failed to get iterative approcah and got some wrong ansers.
//Your code with explanation:- idea is if we traversal one level go to other level height increases. So based on this idea
//setting one variable as parameter in reccursion and for everytime when h>=list.size()[no of elements untill before levels] adding to list and adding will be stopped when it reaches null.
//so to travel from left to right first root.left and root.right is called.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output=new ArrayList<>();
        int h=0;
        bfs(root,output,0);
        
return output;}
    public void bfs(TreeNode root,List<List<Integer>> output,int h){
        if(root==null){
            return ;
        }
        if(h>=output.size()){
            output.add(new LinkedList<Integer>());
        }
         output.get(h).add(root.val);
      
        bfs(root.left,output,h+1);
        bfs(root.right,output,h+1);
    }
}