/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {    //dfs ==>recursion
//
//     List<List<Integer>> result;
//
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         result= new ArrayList<>();
//         if(root ==null) return result;
//         dfs(root,0);
//         return result;
//     }
//     public void dfs(TreeNode root, int depth){
//
//         if(root==null) return;
//
//         if(depth==result.size())
//             result.add(new ArrayList<>());
//
//         result.get(depth).add(root.val);
//
//         dfs(root.left, depth+1);
//         dfs(root.right,depth+1);
//     }
// }

//bfs solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        Queue <TreeNode> q= new LinkedList<>();

        if(root==null) return result;
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            List <Integer> temp=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode curr =  q.poll();
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            } result.add(temp);
        }
        return result;
    }
}