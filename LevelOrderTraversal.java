import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Time Complexity : O(n)
// Space Complexity : max width of the binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1. We maintain a Queue DS since vertex that is first to get in would be first to go out
2. for each level we compute the size of the queue
3. and pop out the node those number of times
4. at the end of the loop we will have next level inside our queue.
*/
public class LevelOrderTraversal{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            result.add(list);
            
        }
        return result;
    }
}