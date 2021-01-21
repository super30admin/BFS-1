
//Time Complexity:O(N)
//Space Complexity:O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=que.poll();
                temp.add(curr.val);
                if(curr.left!=null)que.add(curr.left);
                if(curr.right!=null)que.add(curr.right);
            }result.add(temp);
        }return result;
    }
}