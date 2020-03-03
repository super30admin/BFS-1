// Time Complexity : O(N) (both DFS and BFS)
// Space Complexity : O(N) for BFS, O(H) for DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
// BFS
// var levelOrder = function(root) {
//     if (root == null) return [];
    
//     let result = [],
//         queue = [root],
//         index = 0;
//     while (queue.length) {
//         let currLevel = [];
//         let currLength = queue.length - index;
//         for (let i = 0; i < currLength; i++) {
//             let node = queue.shift();
//             currLevel.push(node.val);
//             if (node.left) queue.push(node.left);
//             if (node.right) queue.push(node.right);
//         }
//         result.push(currLevel);
//     }
//     return result;
// };

// DFS
let result;
var levelOrder = function(root) {
    result = [];
    if (root == null) return result;
    helper(root, 0);
    return result;
};

const helper = (node, level) => {
    // Base Case
    if (!node) return;

    // Logic
    if (level == result.length) result.push([]);
    result[level].push(node.val);
    helper(node.left, level + 1);
    helper(node.right, level + 1);
};
