// Time Complexity : O(n) where n is no. of tree nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */

// BFS - processing parent and its child node together
// BFS uses queue (FIFO)
var levelOrder = function(root) {
    if(!root) return [];
    const queue = [];
    const result = [];
    queue.push(root);
    while(queue.length) {
        const len = queue.length; //No. of nodes to procee at certain level
        let row = [];
        for (let i = 0; i<len; i++) { //For loop to take care of nodes at certain level
            const curr = queue.shift();
            if(curr.left) queue.push(curr.left);
            if(curr.right) queue.push(curr.right);
            row.push(curr.val);
        }
        result.push(row);
    }
    return result;
};