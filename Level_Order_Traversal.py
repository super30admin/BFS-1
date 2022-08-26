'''
Time Complexity - O(n)
Space Complexity - O(n)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.res = []
        if root is None:
            return self.res
        self.dfs(root, 0)
        return self.res

    def dfs(self, root, depth):
        if root is None:
            return
        if depth == len(self.res):
            self.res.append([])

        self.res[depth].append(root.val)
        self.dfs(root.left, depth + 1)
        self.dfs(root.right, depth + 1)
