/*
 * Tc - O(n)
 * Sc - O(n)
 * Approach - we are doing dfs traversal. And before we add to the recursion stack
 * we would add it along with the depth at that point. 
 */

public class LevelOrder {
    // using dfs 
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode node, int depth){
        if(node == null) return;

        //logic 
        int size = result.size();
        if(size == depth){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        //recursion 
        helper(node.left, depth+1);
        helper(node.right, depth+1);
    }

    // using bfs     
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if(root == null) return result;
    //     Queue<TreeNode> q = new LinkedList<>(); 
    //     q.offer(root);
    //     while(!q.isEmpty()){
    //         List<Integer> tmp = new ArrayList<>();
    //         int size = q.size();
    //         for(int i = 0; i < size; i++){
    //             TreeNode curr = q.poll();
    //             tmp.add(curr.val);
    //             if(curr.left != null) q.offer(curr.left);
    //             if(curr.right != null) q.offer(curr.right);    
    //         }
    //         result.add(tmp);
    //     }
    //     return result;
    // }
}
