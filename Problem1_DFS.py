# Time complexity : O(n)
# Space complexity : O(h) --> height of the tree
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
      
        # declaring res variable to store the final res
        self.res = []
        if not root:
            return self.res
        # call the dfs function on root with 0 depth
        self.dfs(root,0)
        return self.res

    def dfs(self, root, depth):
        if not root:
            return 
        
        # we check if the depth is same as the res.size, that means this is a new element at new depth, so make a new list within res 
        # and append the new value
        if depth == len(self.res):
            self.res.append([])
        self.res[depth].append(root.val)
        
        # recursively call the dfs function on left and right subtree along with depth + 1
        self.dfs(root.left, depth+1)
        self.dfs(root.right, depth + 1)
        
