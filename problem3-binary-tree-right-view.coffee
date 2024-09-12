#https://leetcode.com/problems/binary-tree-right-side-view/
#// Time Complexity : O(n) we visit every node once
#// Space Complexity : O(widest diameter), we keep a stack of max widest breadth at each level
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
# Tried 2 approaches before hitting on the passing approach:
#   tried to ignore the left branches at each recursive step
#   tried to go left only if there was no right
#
#// Your code here along with comments explaining your approach
#
# Just like the tree level ordering problem BUT...
# ...when you usually push all the elements at each level
#  ...JUST push the furthest right one because that's the only one you see.
#
# So code is identical to tree level order except for line 46 below.
TreeNode = (val = -1, left = null, right = null) -> Object.assign(
  Object.create(TreeNode::),
  val: val
  left: left
  right: right
)

rightSideView = (root) ->
  output = []

  if root is null
    return output

  queue = []
  queue.unshift(root)

  while queue.length > 0
    size = queue.length
    temp = []
    for x in [0...size]
      front = queue.pop()
      temp.push(front.val)

      if front.left isnt null
        queue.unshift(front.left)

      if front.right isnt null
        queue.unshift(front.right)

    output.push([temp.pop()])

  output

#tree = TreeNode(1, TreeNode(2, null, TreeNode(5)), TreeNode(3, null, TreeNode(4)))
#rightSideView(tree)
#tree = TreeNode(1, TreeNode(2))
#rightSideView(tree)
