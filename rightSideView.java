/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 199. Binary Tree Right Side View
Time Complexity: O(n)
Space Complexityz: O(n)

Breadth first search, at each level add the last element into the queue
Follow-up Question - Binary Tree Left Side View
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size(); // 1
            int temp = 0;
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll(); // 1
                temp = cur.val;

                if(cur.left != null) q.add(cur.left); // Q is now 2,3
                if(cur.right != null)   q.add(cur.right);
            }
            result.add(temp);
        }
        return result;
    }
}

/* 199. Binary Tree Right Side View
Time Complexity: O(n)
Space Complexityz: O(n)

Breadth first search, at each level add the last element into the queue
Follow-up Question - Binary Tree Left Side View
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size(); // 1
            result.add(q.peek().val);  //add here
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll(); // 1
                if(cur.right != null)
                    q.add(cur.right);
                if(cur.left != null)
                    q.add(cur.left); // Q is now 3,2
            }
        }
        return result;
    }
}

/* 199.Binary Tree Left Side View
Time Complexity: O(n)
Space Complexityz: O(n)
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size(); // 1
            int temp = 0;
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll(); // 1
                if(i==0)
                    temp = cur.val;  // notice the change here
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            result.add(temp);
        }
        return result;
    }
}


/* 199.Binary Tree Right Side View
Time Complexity: O(n)
Space Complexityz: O(n)

Depth First Search
*/

class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0); //0 is the depth here
        return result;
    }

    private void helper(TreeNode root, int depth){
        if(root == null)
            return;

        //Base Case
        if(depth == result.size()) // Stack - 1
            result.add(root.val);  // true here so add 3

        helper(root.right, depth+1); // Push 3 into stack, depth is 1
        helper(root.left, depth+1); // Push 2
        // for left side view same but swap the order, first left then right
    }
}

