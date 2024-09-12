//idea:  recrusive solution.
//queue is used to store element at every level. 
//So first root element and is added to queue and then pop it first and add into list. 
//Then element at left and right sides are added to queue and pop out again till all element on the same level are pop out.
//continue  process till leave node and queue is not empty. at the end return list.

//time complexity o(n) 
//space complexity is o(n) maximum element can be stored in queue are 2^h where h is height of tree
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionBinaryTree {
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	//output
        List<List<Integer>> result = new ArrayList<>();
        //null check
        if(root ==null) return result;
        
        //declaring queue
        Queue<TreeNode> q = new LinkedList<>();
        //add first root
        q.add(root);
        
        //iterate till queue empty
        while(!q.isEmpty()){
        	
        	//new level of tree
            List<Integer> list = new ArrayList<>();
            
            //take size of queue means size of element at this perticular level
            int count = q.size();
            //itertate to add element in level
             for(int i=0; i<count; i++){
                TreeNode element =  q.poll();
                list.add(element.val);
                if(element.left!= null) q.add(element.left);
                if(element.right!=null) q.add(element.right);
              }
            result.add(list);
        }
        return result;
        
    }
    
   
}
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
        TreeNode root = new TreeNode(3); 
        root.left = new TreeNode(9); 
        root.right = new TreeNode(20);    
        root.right.left = new TreeNode(15); 
        root.right.right = new TreeNode(7); 
        
        List<List<Integer>> result = new ArrayList<>();
        result = SolutionBinaryTree.levelOrder(root);
        for(int i=0; i<result.size();i++)
        System.out.println("binary level order traversal of tree"+result.get(i));

	}

}
