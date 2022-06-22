// timecomplexity : O(n)
// space complexity: O(n)
import java.util.*;
 
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) 
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode ele = q.poll();
                li.add(ele.val);
                if(ele.left!=null) q.add(ele.left);
                if(ele.right!=null) q.add(ele.right);
            }
            result.add(li);
        }
        return result;
    }
   
    }

