import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(H)
public class LevelOrderTraversal {
	static class TreeNode {	
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
	
	/** Approach: DFS **/
	List<List<Integer>> result;
	public List<List<Integer>> levelOrder(TreeNode root) {
		result= new ArrayList<>();
		dfs(root,0);
		return result;
	}
	
	private void dfs(TreeNode root, int level) {
		//base
		if(root == null) return;
		
		//logic		
		if(result.size() == level) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(root.val);
		
		dfs(root.left,level+1);
		dfs(root.right,level+1);		
	}

	// Driver code to test above 
    public static void main(String args[]) {
    	LevelOrderTraversal ob = new LevelOrderTraversal();
    	TreeNode root= new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));	
    	
		System.out.print("Level order traversal of given tree : "+ ob.levelOrder(root));		
    } 
}
