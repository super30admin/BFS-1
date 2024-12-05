# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        """
        3, q = 9, 20
l = 1
        """
        if not root:
            return []

        q = [root]
        result = []

        while q:
            l = len(q)
            level = []
            for i in range(l):
                cur = q.pop(0)
                if cur.left: q.append(cur.left)
                if cur.right:q.append(cur.right)
                level.append(cur.val)
            
            result.append(level)

        return result




















        
        # queue = []
        # res = []
        # if not root: return []
        # queue.append(root)
        # # res.append([root.val])
        # while queue:
        #     level = []
        #     counter = len(queue)

        #     while counter:
        #         node = queue.pop(0)
        #         level.append(node.val)

        #         if node.left:
        #             queue.append(node.left)
                
        #         if node.right:
        #             queue.append(node.right)
        #         counter -= 1
        #     res.append(level)
        # return res
               
        
