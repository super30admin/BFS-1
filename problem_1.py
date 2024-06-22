# Time O(N)
# Space O(N)
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        queue = deque([root])
        size = 0
        result = [] 
        while queue:
            size = len(queue)
            tmp = []
            for i in range(size):
                curr = queue.popleft()
                tmp.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(tmp)
        return result


        
        