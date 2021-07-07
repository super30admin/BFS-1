# Time Complexity : O(n)
# Space Complexity : O(k) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        q = []
        result = []
        if root is None:
            return result
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if i == size-1:
                    result.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return result