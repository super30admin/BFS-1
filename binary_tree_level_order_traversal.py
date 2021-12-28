# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

# Approach
# BFS (queue)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        q = deque([root])
        while q:
            temp = []
            for _ in range(len(q)):
                x = q.popleft()
                temp.append(x.val)
                if x.left:
                    q.append(x.left)
                if x.right:
                    q.append(x.right)
            res.append(temp)
        return res


# TC: O(N)
# SC: O(H)

# Approach
# DFS with implicit stack (recursion)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        self.dfs(root, 0, res)
        return res
        
    def dfs(self, node, level, res):
        if not node:
            return
        if len(res) == level:
            res.append([])
        res[level].append(node.val)
        self.dfs(node.left, level+1, res)
        self.dfs(node.right, level+1, res)