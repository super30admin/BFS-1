
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# BFS
-------------------------------

#Time :O(n)
#Space :O(n)
from collections import deque
class Solution:

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        result = []
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            temp = []
            for _ in range(size):
                currrent = queue.popleft()
                temp.append(currrent.val)
                if currrent.left:
                    queue.append(currrent.left)
                if currrent.right:
                    queue.append(currrent.right)
            result.append(temp)
        return result

    
    
#DFS
#--------------------------------------------------
#space O(h)
#time O(N)
  # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.result = []
        if self.result == None:
            return self.result
        self.helper(root, 0)
        return self.result
            
    def helper(self, root, level):
        if(not root):
            return
        if(level == len(self.result)):
            self.result.append([])
        self.result[level].append(root.val)
        self.helper(root.left, level + 1)
        self.helper(root.right, level + 1)
