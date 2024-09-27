import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */
//Time complexity would be O(n) since we are recursing through all nodes and Space complexity would be O(n) since we are 
//maintaining a queue for the traversed nodes.
class Node  
{ 
    int data; 
    Node left, right; 
       
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 

public class level_order_traversal {

	/**
	 * @param args
	 */
	
	Node root;
	
	
	  public List<List<Integer>> levelOrder(Node root) {
	        
	        if(root==null){return null;}
	        Queue<Node> q = new LinkedList<Node>();
	        
	        List<List<Integer>> finallist = new ArrayList<>();
	       
	        q.add(root);
	        
	        while(!q.isEmpty()){
	             
	            List<Integer> templist= new ArrayList<>();
	            for(int i=0;i<q.size();i++)
	            {
	                
	                Node p = q.poll();     
	                templist.add(p.data);
	                System.out.println(p.data);
	                if(p.left!=null){
	                    q.add(p.left);
	                }
	            
	                if(p.right!=null){
	                    q.add(p.right);
	                }
	                
	            }
	            
	          
	        
	          finallist.add(templist);
	            
	        }
	     
	        return finallist;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		level_order_traversal tree = new level_order_traversal(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
		
		
	}

}
