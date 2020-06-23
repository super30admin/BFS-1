//Time complexity:O(n)
//Space complexity: O(n)

//BREADTH FIRST SEARCH  
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode curr=root; //Just so we can add it after FOR loop. Could have used another variable too
            for(int i=0;i<size;i++){
                curr=q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                
            }
            result.add(curr.val);
        }
        return result;
    }
}