//time - O(n)
//space - O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            result.add(new ArrayList<>());
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                result.get(result.size()-1).add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }

        return result;
    }
}
