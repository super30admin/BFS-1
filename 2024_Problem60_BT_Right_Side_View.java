//199. BT Right Side View - https://leetcode.com/problems/binary-tree-right-side-view/description/
//Time Complexity: O(n)
//Space Complexity: O(n/2) ~ O(n)

//BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                //if last element of the level -> add to the result
                if(i == size-1){
                    result.add(curr.val);
                }
                //check for left child
                if(curr.left != null){
                    q.add(curr.left);
                }
                //check for right child
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}

//DFS
//Time Complexity: O(n)
//Space Complexity: O(h) -> stack space
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int depth){
        //base case
        if(root == null){
            return;
        }
        //logic
        if(depth == result.size()){
            result.add(root.val);
        }

        helper(root.right, depth+1);
        helper(root.left, depth+1);
    }
}