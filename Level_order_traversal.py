# TC: O(n)
# SC: O(h)
# Does this code run on Leetcode: Yes
# Did you find any difficulties while coding this: No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        result = []
        queue = deque([root])
        while queue:
            result.append([])
            current_visit_level = len(queue)
            for i in range(current_visit_level):
                current = queue.popleft()
                result[-1].append(current.val)
                
                if current.left:
                    queue.append(current.left)
                    
                if current.right:
                    queue.append(current.right)
        return result