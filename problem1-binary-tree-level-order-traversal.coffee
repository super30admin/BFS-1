#https://leetcode.com/problems/binary-tree-level-order-traversal/
#// Time Complexity : O(n) we visit every node once
#// Space Complexity : O(widest diameter), we keep a stack of max widest breadth at each level
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
# I am not used to preorder tree traversal need to internalize this
#
#// Your code here along with comments explaining your approach
#
# Visit a tree preorder, that is root, then leftchild, rightchild
# Pass in the level at each recursion level
# Output will be an array of arrays, the level will be the 2nd level of array
# e.g.
# output = [
#    level 0 [root node]
#    level 1 [root children]
#    level 2 [root grandchildren]
#    etc ]

TreeNode = (val = -1, left = null, right = null) -> Object.assign(
  Object.create(TreeNode::),
    val: val
    left: left
    right: right
  )

levelOrder = (root) ->
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

    output.push(temp)

  output

tree = TreeNode(3, TreeNode(9, TreeNode(20, TreeNode(15), TreeNode(7))))
levelOrder(tree)
