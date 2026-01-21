//way1
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
 //Place root node in queue
 //Rootnode acts as parent
 //Travel through queue based on it's size and add them to list
 //Once travelled till size, add list to ans and continue with new size and so on
 //ie., travelling parent - it's children - it's grandchildren so on
 //TC: O(n); SC:O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!(queue.isEmpty())){
            int size=queue.size();
            List<Integer> curr=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currNode=queue.poll();
                curr.add(currNode.val);

                if(currNode.left!=null){
                    queue.add(currNode.left);
                }

                if(currNode.right!=null){
                    queue.add(currNode.right);
                }

            }

            ans.add(curr);
        }

        return ans;
        
        
    }
}

//way2
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
 //DFS
 //Maintain ans as List of List --> reference
 //Check level at every node
 //If that level is already present in ans, add it to the subList of ans at level. Else, create new List, add element and add that list to ans
 //TC: O(n); SC:O(h)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(root,0,ans);
        return ans;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> ans){
        if(root==null){
            return;
        }


        if(level==ans.size()){
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.val);

        helper(root.left,level+1,ans);
        helper(root.right,level+1,ans);
    }
}
