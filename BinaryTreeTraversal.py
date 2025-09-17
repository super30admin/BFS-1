# Time Complexity : O(N) where N is the number of nodes in the tree
# Space Complexity : O(h) where h is the recursion stack space maximum height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a recursive approach to perform level order traversal of the binary tree.
# I define a helper function that takes the current node and its level as arguments.
# If the current node is None, I return an empty list.
# If the current level is equal to the length of the result list, I append a new empty list to the result.
# I then append the value of the current node to the corresponding level list in the result.
# I recursively call the helper function for the left and right children of the current node, incrementing the level by 1.
# Finally, I return the result list containing all levels of the tree.

from typing import List, Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res =[]
        def helper(root,level):
            if not root:
                return []
            if level == len(res):
                res.append([])
            res[level].append(root.val)
            helper(root.left,level+1)
            helper(root.right,level+1)
        helper(root,0)
        return res