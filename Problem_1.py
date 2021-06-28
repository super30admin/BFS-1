# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# BFS Solution
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if root == None:
            return result
        q = deque()
        q.append(root)
        
        while len(q) != 0:
            size = len(q)
            li = []
            for i in range(size):
                curr = q.popleft()
                li.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)     
            result.append(li)     
            
        return result

# Time Complexity : O(n)
# Space Complexity : O(n/2) 

# DFS Solution
# class Solution:
#     def levelOrder(self, root: TreeNode) -> List[List[int]]:
#         self.result = []
#         if root == None:
#             return self.result
#         self.dfs(root, 0)
#         return self.result

#     def dfs(self, root: TreeNode, level: int) -> None:
#         if root == None:
#             return
#         if len(self.result) == level:
#             self.result.append(list())
#         self.result[level].append(root.val)
#         self.dfs(root.left, level + 1)
#         self.dfs(root.right, level + 1)

# Time Complexity : O(n)
# Space Complexity : O(h) 