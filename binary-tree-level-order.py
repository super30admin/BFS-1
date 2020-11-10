# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        # BFS
        #         if not root:
        #             return []
        #         q=deque()
        #         q.append(root)
        #         final=[]

        #         while q:
        #             lis=[]
        #             length=len(q)
        #             for i in range(length):

        #                 root1=q.popleft()
        #                 lis.append(root1.val)
        #                 if root1.left:
        #                     q.append(root1.left)
        #                 if root1.right:
        #                     q.append(root1.right)
        #             final.append(lis)
        #         return final
        # time-O(n) space-o(n)
        # dfs
        def dfs(root, level):
            if not root:
                return
            if level == len(result):
                result.append([])
            result[level].append(root.val)
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)

        result = []
        dfs(root, 0)
        return result
    # time-O(n)space-o(h)

