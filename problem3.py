# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.helper(root, 0)
        
        return self.result
    
    def helper(self, root, level):
        if root is None:
            return
        self.helper(root.left, level+1)
        self.helper(root.right, level+1)
        if len(self.result) < level+1:
            self.result = [0 for _ in range(level+1)]
        self.result[level] = root.val