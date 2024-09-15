/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// DFS
// Time Complexity - O(n)
// Space Complexity - O(1) - without recursive stack
//                    O(n) - with recursive stack
// BFS
// Time Complexity - O(n)
// Space Complexity - O(n)
//
class Solution {
    List<List<Integer>>  result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        // dfs(root,0);
        // return result;
        if(root== null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i< size;i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);

                if(curr.right != null)
                    q.add(curr.right);
            }
            result.add(list);
        }


        return result;
    }


    private void dfs(TreeNode root, int level){

        if(root==null){
            return;
        }

        if(level == result.size()){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}