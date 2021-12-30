// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// BFS approach
var levelOrder = function (root) {
  const resultsArr = [];
  if (!root) return resultsArr;

  const queue = [root];

  while (queue.length) {
    let length = queue.length;
    let auxArr = [];
    while (length--) {
      let root = queue.shift();
      auxArr.push(root.val);
      root.left !== null && queue.push(root.left);
      root.right !== null && queue.push(root.right);
    }
    resultsArr.push(auxArr);
  }
  return resultsArr;
};

// DFS approach
var levelOrder = function (root) {
  const resultsArr = [];
  if (!root) return resultsArr;

  const dfs = (root, level) => {
    // base
    if (!root) {
      return;
    }

    // logic
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);

    if (resultsArr[level] === undefined) {
      resultsArr[level] = [root.val];
    } else {
      resultsArr[level].push(root.val);
    }
  };

  dfs(root, 0);
  return resultsArr;
};
