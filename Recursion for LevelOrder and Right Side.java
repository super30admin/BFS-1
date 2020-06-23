//<-----Level Order---->
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result  = new ArrayList<>();
		if (root == null)
			return result;
		levelOrderHelper(result, root, 0);
		return result;
	}
	
	public void levelOrderHelper(List<List<Integer>> result, TreeNode root, int level) {
		if (root == null)
			return;
		List<Integer> curr;
		if (level >= result.size()) {
			curr = new ArrayList<>();
			curr.add(root.val);
			result.add(curr);
		} else {
			curr = result.get(level); 
			curr.add(root.val); 
			//res.add(curr); // No need to add the curr into the res, because the res.get(index) method does not remove the index element
		}
		levelOrderHelper(result, root.left, level + 1);
		levelOrderHelper(result, root.right, level + 1);
	}
}

//<------Right Side View----->
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){ //makes sure the first element of that level will be added to the result list
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1); //right side first
        rightView(curr.left, result, currDepth + 1);
        
    }
}


