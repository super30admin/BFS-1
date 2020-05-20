// # Problem 3
// Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

// O(n) time, O(h) space

const rightSideView = function(root) {
    if(!root) return [];
    let res = [];
    dfs(root, 0);
    return res;
    
    function dfs(root, level) {
        // base
        if(!root) return;
        // logic
        if(level === res.length) res.push(root.val);
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }    
};