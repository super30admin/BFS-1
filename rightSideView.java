//Time Complexity:O(N)or O(V+M), where V is the vertex and E is the edge.
//Space Complexity:O(N)
//In this problem. I'll be creating a result list which will be holding my right side view. I'll be using a queue to keep track of my left and the right child of my current node. I'll then be iterating through the length of the queue at that instant. I'll be adding the last node value at each iteration to my result list, which will be my right view.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
                if(i==size-1){
                    res.add(node.val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                
            }
            
        }
        return res;
    }
}