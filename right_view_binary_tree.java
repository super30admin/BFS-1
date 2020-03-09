import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */
//Time complexity would be O(n) since we are iterating through all the nodes 
//Space complexity would be O(n) since we are storing nodes the nodes in the queue

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

public class right_view_binary_tree {

	/**
	 * @param args
	 */
	
	Node root;
	
	public void rightView(Node root)
	{
		// return if tree is empty
		if (root == null) {
			return;
		}

		// create an empty queue and enqueue root node
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);

		// pointer to store current node
		Node curr = null;

		// run till queue is not empty
		while (!queue.isEmpty())
		{
			// calculate number of nodes in current level
			int size = queue.size();
			int i = 0;

			// process every node of current level and enqueue their
			// non-empty right and right child to queue
			while (i++ < size) {
				curr = queue.poll();

				// if this is last node of current level, print it
				if (i == size) {
					System.out.print(curr.data + " ");
				}

				if (curr.left != null) {
					queue.add(curr.left);
				}

				if (curr.right != null) {
					queue.add(curr.right);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		right_view_binary_tree tree = new right_view_binary_tree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
          
        tree.rightView(tree.root); 
		
		

	}

}
