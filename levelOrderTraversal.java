// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal{


public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result=new ArrayList<>();
     Queue<TreeNode> queue=new LinkedList<>();
    
    if(root==null)
        return result;
    
    queue.add(root);
    
    while(!queue.isEmpty()){
        int size=queue.size();
        List<Integer> temp=new ArrayList<>();
        
        for(int i=0;i<size;i++){
            
            TreeNode current=queue.remove();
            temp.add(current.val);
            if(current.left!=null)
                queue.add(current.left);
            
            if(current.right!=null)
                queue.add(current.right);
            
        }
        result.add(temp);
        
    }
    
    return result;
}
}