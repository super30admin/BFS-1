//Time complexity: O(n)
//Space complecity: O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList();
        int level=0;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            result.add(new ArrayList());
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                result.get(level).add(curr.val);
                if(curr.left!=null){
                q.add(curr.left);
                }
                if(curr.right!=null){
                q.add(curr.right);
                }
            }
            level++;
        }
        return result;
    }
}