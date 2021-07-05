// # Problem 1
// Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

const levelOrder = function(root) {
    if (!root) return [];
    const q = [];
    q.push(root);
    const result = [];
    while (q.length > 0) {
        const size = q.length;
        const temp = [];
        for (let i = 0; i < size; i++) {
            const node = q.shift();
            temp.push(node.val);
            if (node.left) q.push(node.left);
            if (node.right) q.push(node.right);
        }
        result.push(temp);
    }
    return result;
};