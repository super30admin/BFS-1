/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//BFS Approach

class Solution {

    //Time Complexity : 0(n) where n is the no. of nodes
    //Space Complexity: 0(n) where n is the nodes
    //Did it successfully run on leetcode: Yes
    //Did you face any problem: No

    //In Short explain your approach: I took a ques to traverse BFS. Then I added the root to my queue as the traversal starts
    //from root. Then I ran a while loop till my queue is empty. I created a variable size to keep a track of the size of the
    //queue so that all the elements are extracted at that particular level. Then I am creating a new list at every level
    //to return the output as per every level. I run a for loop till the size of my queue. I pop the 1st element from the queue
    //and add it to my list. Then check if my root has a left or right child. If yes, add them both to my queue. After that,
    //when I exit for loop, I add my list to my final resultant list.

    List <List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List <Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                li.add(current.val);
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
            result.add(li);
        }
        return result;
    }
}

//DFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //Time Complexity : 0(n) where n is the no. of nodes
    //Space Complexity: 0(h) where h is the height of the tree
    //Did it successfully run on leetcode: Yes
    //Did you face any problem: No

    //In Short explain your approach: I am passing the root and the level to my helper method. In my helper method, I am checking
    //if the level is equal to the size of the resultant array's index, then I am adding a new array list in my resultant
    //array as the level is encountered for the 1st time. Then I am getting the level of tree I am at and then adding the
    //value at that particular level in the result. Then I am traversing the left and right subtree adding the level at each
    //recursive call.

    List <List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level+1);
    }

}