// Time Complexity : O(n) as we are traversing through all nodes once
// Space Complexity: O(n/2) = O(n) because we are basically storing width of elements

// BFS Approach
// Using a Queue (BFS), for each level, maintain a size so that one new ArrayList is created and the size number of
// elements are added to that List (or Level).
import java.util.Queue;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            result.add(temp);
        }
        return result;
    }
}

// DFS Approach
// Time - O(n) || Space - O(h) h = ht of stack
// Add the level as an extra parameter to each recursive call and add the node of corresponding level

to the corresponding List.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root==null) return result;
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root==null) return;
        if(result.size()==level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}