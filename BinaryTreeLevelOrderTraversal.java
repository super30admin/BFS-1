// Time Complexity : O(n) where  n is no.of nodes
// Space Complexity : O(n) for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We can solve the problem using BSF. You maintain the queue and push root in the queue
 * Maintain the size variable of the queue to process all the nodes on the same level at
 * same time. Push the left and right child if not null for the node removed form the queue.
 * */

public class BinaryTreeLevelOrderTraversal {

    //BSF
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        ((LinkedList<TreeNode>) q).add(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null) ((LinkedList<TreeNode>) q).add(node.left);

                if(node.right!=null) ((LinkedList<TreeNode>) q).add(node.right);
            }
            result.add(temp);
        }
        return result;
    }


    List<List<Integer>> resultArr;
    //using DSF
    public List<List<Integer>> levelOrderDFS(TreeNode root){
        resultArr = new ArrayList<>();
        if(root==null) return resultArr;

        dfs(root, 0);
        return resultArr;
    }

    private void dfs(TreeNode root, int level) {
        //edge
        if(root==null) return;
        //logic
        if(resultArr.size()==level){
            resultArr.add(new ArrayList<>());
        }
        resultArr.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
