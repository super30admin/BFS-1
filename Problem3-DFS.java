/** Binary Tree Right Side View - DFS Approach
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <--- */

  // Time Complexity : O(n) as it traverses each node exactly once
// Space Complexity : O(n) as it uses the recursive stack and put all elements atleast once
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//approach- We can work with BFS or DFS both
//DFS Approach- we are going to maintain two things here:
//1. Depth variable(to keep a track of depth once we visit the elements at each level)
//2. resultant list to add elements based on our logic
//logic: we create a recursive stack. we start with root and check if(depth == result.size()). if that is true, then we add that element to the result and add to recursive stack
//we keep going down and visit its children and work with the same depth logic once we have pushed our elements in the result list

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //starting at the first level
        helper(root, result, 0);
        return result;
    }
    //abstraction-as this private function is only accessible by data memebers of this class
    private void helper(TreeNode root, List<Integer> result, int depth){
        //edge-graph doesn't exist
        if(root == null) return;
        //base case-logic, keep adding root value if depth equals result size
        if(depth == result.size()) result.add(root.val);
        //starts with right children
        helper(root.right, result, depth+1);
        helper(root.left, result, depth+1);
    }
}