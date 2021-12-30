import java.util.*;

public class LevelOrderTraversal {

    public class TreeNode {
        int val;
        LevelOrderTraversal.TreeNode left;
        LevelOrderTraversal.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        /*
        Approach 1. Using BFS

        TC:O(n)
        SC:O(n)

        */
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                l.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(l);
        }
        return result;
    }

    /*
    * Approach 2. Using DFS
    *
    */
    List<List<Integer>> result;
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
    /*

    TC:O(n)
    SC:O(Height)-> O(n)

    */
        result=new ArrayList<>();
        if(root==null) return result;
        dfs(root,0);
        return result;
    }

    private void dfs(TreeNode root,int level){
        if(root==null){
            return;
        }

        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);

        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
