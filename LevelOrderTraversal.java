//Time Complexity :O(N)
//Space Complexity :O(1) extra other than storing the result.
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class LevelOrderTraversal {
    public List<Integer> rightSideView(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
        if(null == root){return result;}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        TreeNode temp = null;
        while(!q.isEmpty()){
            size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                temp = q.poll();
                list.add(temp.val);
                if(null != temp.left){q.add(temp.left);}
                if(null != temp.right){q.add(temp.right);}
            }
            result.add(list);
        }
    return result;
    }
}