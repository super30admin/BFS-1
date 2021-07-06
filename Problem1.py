# Time Complexity: O(N)
# Time Complexity: O(2^H) H is the height of the binary tree
# Passed Leetcode 

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return 
        queue = deque([(root, 1)])
        out = []
        while len(queue) > 0:
            
            node, level = queue.popleft()
            
            if len(out) > level - 1:
                out[level - 1].append(node.val)
            else:
                out.append([node.val])
            
            if node.left:
                queue.append((node.left, level + 1))
              
            if node.right:
                queue.append((node.right, level + 1))
        
        return out