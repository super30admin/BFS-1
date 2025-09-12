"""
TC: O(N) {we iterate through all the elements of the tree only once}
SC: O(1) {we don't use any extra space, if we consider the stack space, the max space can be O(H), H is the height of the tree, in turn it could be N if the tree is skewed.}

Approach:

We take the DFS approach and create a helper function with node and its level as the parameters. For every level, we store the node's val
in the corrsponding bucket (inside array) if there exists one or create one.

We do it for the height of the tree for each and every element and return the result.

The problem ran successfully on LeetCode.
"""
from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def _helper(self, node, level):
        if not node:
            return
        
        if len(self.res) <= level:
            self.res.append([])
        self.res[level].append(node.val)

        self._helper(node.left, level+1)
        self._helper(node.right, level+1)

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        self.res = []
        self._helper(root, 0)
        return self.res
        
