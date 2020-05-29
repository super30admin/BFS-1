# Time Complexity : O(n) where n is number of nodes in tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root):
        if root is None:
            return None
        result = []
        current = [root]
        while current:
            result.append([i.val for i in current])
            temp = []
            for i in current:
                if i.left:
                    temp.append(i.left)
                if i.right:
                    temp.append(i.right)
                current = temp[:]
        return result
