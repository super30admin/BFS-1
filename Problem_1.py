# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def levelOrder(self, root):
        result = []
        if not root:
            return result
        q = deque()
        q.append(root)
        while q:
            qSize = len(q)
            temp = []
            for i in range(qSize):
                front = q.popleft()
                temp.append(front.val)
                if front.left:
                    q.append(front.left)
                if front.right:
                    q.append(front.right)
            result.append(list(temp))
        return result
    

'''
DFS Code

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = []
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, level):
        if not root:
            return
        if level >= len(self.result):
            self.result.append([root.val])
        else:
            self.result[level].append(root.val)
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)

'''
