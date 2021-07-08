// Time Complexity : O(N) for BFS and DFS
// Space Complexity : O(N) for BFS, O(H) for DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Challenged myself to do BFS, DFS (iterative), and DFS (recursive).  For iterative,
// I only had a problem with the order I pushed onto the stack.

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
// BFS
// var rightSideView = function(root) {
//     if (root == null) return [];
    
//     let result = [],
//         queue = [root],
//         index = 0;
//     while (queue.length) {
//         let size = queue.length - index;
//         let last = 0;
//         for (let i = index; i < size; i++) {
//             let curr = queue[index++];
//             last = curr.val;
//             if (curr.left) queue.push(curr.left);
//             if (curr.right) queue.push(curr.right);
//         }
//         result.push(last);
//     }
//     return result;
// };

// DFS (iterative)
// var rightSideView = function(root) {
//     if (root == null) return [];
    
//     let result = [],
//         stack = [0, root];
    
//     while (stack.length) {
//         let node = stack.pop(),
//             level = stack.pop();
        
//         if (level == result.length) result.push(node.val);
        
//         if (node.left) stack.push(level + 1, node.left);
//         if (node.right) stack.push(level + 1, node.right);
//     }
//     return result;
// }

// DFS (recursive)
let result;
var rightSideView = function(root) {
    result = [];
    if (root == null) return result;
    dfs(root, 0);
    return result;
}
let dfs = (root, depth) => {
    // Base Case
    if (root == null) return;
    
    // Logic
    if (depth == result.length) result.push(root.val);
    dfs(root.right, depth + 1);
    dfs(root.left, depth + 1);
}
