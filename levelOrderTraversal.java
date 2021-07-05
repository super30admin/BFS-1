//Time Complexity:O(N)or O(V+M), where V is the vertex and E is the edge.
//Space Complexity:O(N)
//In this problem, I'll be traversing the tree nodes, level by level. Initially, I'll be having a queue, which will keep track of each node's left and right child.  I'll then iterate through the size of the queue at that instant and then add the top of the queue to the list. I'll then find the left and the right child of that node and it to the queue and then add the list at that level to my resultant list of list.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int count=q.size();
            for(int i=0;i<count;i++){
                TreeNode node=q.remove();
                level.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}