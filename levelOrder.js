/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 * Intuition:
 * We perform a level-order traversal using a queue. Instead of removing elements with shift() (which is costly in JavaScript), we simulate the queue using an index pointer.
 *  The queue stores nodes level by level, and the index represents the current front of the queue. For each level, we calculate how many nodes belong to that level as queue.length - idx.
 * We then process exactly those nodes, add their values to the result, and push their children to the queue. 
 * This way, every node is visited once, levels are clearly separated, and the traversal runs efficiently in linear time

 T.C: O(n),
 S.C: O(n)
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    const res = [];
    if (!root) return res;
    const queue = [root];
    let idx = 0;
    while (idx < queue.length) {
        const currLevelNodes = [];
        const currLength = queue.length - idx;
        for (let i = 0; i < currLength; i++) {
            const currRoot = queue[idx++];
            currLevelNodes.push(currRoot.val);
            if (currRoot.left) queue.push(currRoot.left);
            if (currRoot.right) queue.push(currRoot.right);
        }
        res.push(currLevelNodes);
    }
    return res;
};