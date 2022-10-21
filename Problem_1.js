// DFS
// Time Complexity : O(n); n is total nodes
// Space Complexity : O(h); h is the tree height

// BFS
// Time Complexity : O(n); n is total nodes
// Space Complexity : O(n); n is total nodes

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// # Problem 1
// Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

let result;

let dfs = (root, level) => {
    // Base case
    if (root === null) return;

    // Logic
    // If the result doea not contain a list at the index of level, create one
    // Then add the root value to that list
    if (result.length === level)
        result.push([]);
    result.at(level).push(root.val);

    // DFS for left and right children
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
}

/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    if (root === null)
        return [];

    result = [];

    // Maintain level of each node
    dfs(root, 0);


    // // BFS
    // let q = [];
    // q.push(root);
    // // While there are nodes left to traverse
    // while(q.length > 0){
    //     let length = q.length;
    //     let li = [];
    //     // Loop through the nodes on each level which is same as the queue length
    //     for(let i=0; i<length; i++){
    //         let node = q.shift();
    //         // Add the value to list
    //         li.push(node.val);
    //         // Add the nodes left and right child if exists
    //         if(node.left !== null)  
    //             q.push(node.left);
    //         if(node.right !== null)  
    //             q.push(node.right);
    //     }
    //     // Add the list of node values for each level to the result
    //     result.push(li);
    // }
    return result;
};