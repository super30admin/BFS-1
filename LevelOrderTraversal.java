// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Using Breadth First Search

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if(root == null){
            return levels;
        }
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        int level = 0;

        while(!que.isEmpty()){
            levels.add(new LinkedList<>());

            int levelLength = que.size();
            for(int i = 0; i < levelLength; i++){
                TreeNode node = que.remove();

                levels.get(level).add(node.val);

                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }

            level++;
        }

        return levels;
    }
}
