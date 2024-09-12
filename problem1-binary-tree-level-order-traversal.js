//https://leetcode.com/problems/binary-tree-level-order-traversal/
//// Time Complexity : O(n) we visit every node once
//// Space Complexity : O(widest diameter), we keep a stack of max widest breadth at each level
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// I am not used to preorder tree traversal need to internalize this

//// Your code here along with comments explaining your approach

// Visit a tree preorder, that is root, then leftchild, rightchild
// Pass in the level at each recursion level
// Output will be an array of arrays, the level will be the 2nd level of array
// e.g.
// output = [
//    level 0 [root node]
//    level 1 [root children]
//    level 2 [root grandchildren]
//    etc ]
var TreeNode, levelOrder, tree;

TreeNode = function(val = -1, left = null, right = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    val: val,
    left: left,
    right: right
  });
};

levelOrder = function(root) {
  var front, i, output, queue, ref, size, temp, x;
  output = [];
  if (root === null) {
    return output;
  }
  queue = [];
  queue.unshift(root);
  while (queue.length > 0) {
    size = queue.length;
    temp = [];
    for (x = i = 0, ref = size; (0 <= ref ? i < ref : i > ref); x = 0 <= ref ? ++i : --i) {
      front = queue.pop();
      temp.push(front.val);
      if (front.left !== null) {
        queue.unshift(front.left);
      }
      if (front.right !== null) {
        queue.unshift(front.right);
      }
    }
    output.push(temp);
  }
  return output;
};

tree = TreeNode(3, TreeNode(9, TreeNode(20, TreeNode(15), TreeNode(7))));

levelOrder(tree);

//# sourceMappingURL=problem1-binary-tree-level-order-traversal.js.map
