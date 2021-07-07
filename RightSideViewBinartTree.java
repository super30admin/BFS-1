// Time Complexity : O(n)
// Space Complexity : O(2^maxheight)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBinartTree {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        que.add(root);

        while(!que.isEmpty()){
            int levelLength = que.size();
            List<TreeNode> subList = new ArrayList<>();
            for(int i = 0; i < levelLength; i++){
                TreeNode node = que.remove();
                subList.add(node);

                if(node.left != null){
                    que.add(node.left);
                }

                if(node.right != null){
                    que.add(node.right);
                }
            }
            TreeNode dum = subList.get(subList.size() - 1);
            res.add(dum.val);
        }

        return res;
    }
}
