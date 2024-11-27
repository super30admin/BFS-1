//102. Binary Tree Level Order Traversal - https://leetcode.com/problems/binary-tree-level-order-traversal/description/
//Time Complexity: O(n)
//Space Complexity: O(n/2) ~ O(n)

//BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;
        //queues are written using LinkedList
        Queue<TreeNode> q = new LinkedList<>();
        //add root element
        q.add(root);

        while(!q.isEmpty()){
            //get size
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            //process each level by size
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}

//DFS
//Time Complexity: O(n)
//Space Complexity: O(h) -> Stack Space
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root, 0); //depth
        return result;
    }

    private void helper(TreeNode root, int depth){
        //base case
        if(root == null){
            return;
        }
        //logic
        if(result.size() == depth){
            //create list at the index of result
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);

        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }

}