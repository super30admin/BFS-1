// Time Complexity : O(n)
// Space Complexity : DFS-O(h), BFS-O(n)
// Did this code successfully run on Leetcode : Yes

//BFS
let result
var levelOrder = function (root) {
    result = [];
    if (!root) return result;
    let q = [root];
    while (q.length) {
        let size = q.length;
        let li = [];
        for (let i = 0; i < size; i++) {
            const current = q.shift();
            li.push(current.val);
            if (current.left) {
                q.push(current.left);
            }
            if (current.right) {
                q.push(current.right);
            }
        }
        result.push(li);
    }

    return result;

};


//DFS
let result
var levelOrder = function (root) {
    result = [];
    if (!root) return result;
    dfs(root, 0);
    return result;

};

var dfs = function (root, level) {
    if (!root) return;
    if (result.length === level) {
        result.push([]);
    }
    result[level].push(root.val);
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
}
