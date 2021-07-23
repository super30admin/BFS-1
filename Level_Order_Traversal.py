# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Space: O(n)
#Time: O(n)
from collections import defaultdict
from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.levels = []
        def helper(root,index):
            if not root:
                return
            if len(self.levels) == index:
                self.levels.append([])
            self.levels[index].append(root.val)
            helper(root.left,index+1)
            helper(root.right,index+1)
        if not root:
            return []
        helper(root,0)
        return self.levels
        