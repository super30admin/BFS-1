# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if root == None:
            return result
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            last = 0
            for _ in range(size):
                currrent = queue.popleft()
                last = currrent.val
                if currrent.left:
                        queue.append(currrent.left)
                if currrent.right:
                    queue.append(currrent.right)
            result.append(last)
        return result
