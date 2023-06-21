#Time and space complexity = O(N) and O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.result = []
        if root is None:
            return self.result
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root: TreeNode, level: int) -> None:
        # base
        if root is None:
            return
        # Logic
        if level == len(self.result):
            self.result.append([])
        self.result[level].append(root.val)
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)