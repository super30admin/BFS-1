// Time Complexity :
//BFS: O(n) where n is the number of nodes
//DFS: O(n)
// Space Complexity :
//BFS: O(n) where n is the number of nodes as there would be n/2 items in the queue at max
//DFS: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class LevelOrderTraversal {
    private List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }

        bfs(root, result);
        dfs(root, 0);
        return result;
    }

    public void bfs(TreeNode root,  List<List<Integer>> result){

        int count = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            for(int i =0; i<count; i++){

                TreeNode currentNode = q.remove();
                levelList.add(currentNode.val);

                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
            count = q.size();
            result.add(levelList);
        }
    }

    public void dfs(TreeNode root, int level){

        if(root == null){
            return;
        }
        List<Integer> ll;
        if(result.size() == level){
            ll = new ArrayList<>();
            result.add(ll);
        }else{
            ll = result.get(level);
        }

        ll.add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}