# Time Complexity - O(N)
# Space Complexity - O(1)

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
        
        queue = deque()
        queue.append([root, 1])
        level_map = dict()
        
        while queue:
            value, level = queue.popleft()
            if level in level_map.keys():
                level_map[level].append(value.val)
            else:
                level_map[level] = [value.val]
            if value.left:
                queue.append([value.left, level+1])
            if value.right:
                queue.append([value.right, level+1])
        
        return level_map.values()