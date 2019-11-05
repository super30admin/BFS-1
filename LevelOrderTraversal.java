//Time Complexity :O(N)
//Space Complexity :O(1) extra other than storing the result.
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class LevelOrderTraversal {
    int distance = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root){return result;}
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(0 == i){
                    result.add(temp.val);
                }
                if(null != temp.right){
                    q.offer(temp.right);
                }
                if(null != temp.left){
                    q.offer(temp.left);
                }
            }
        }
    return result;
    }
}