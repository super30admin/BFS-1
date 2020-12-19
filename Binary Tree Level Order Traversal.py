# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Iterative Approach:

Add nodes to queue traversing their left and right child, increasing level.

Time: O(N)
Space: O(N)

'''
from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root: return []
        results = []
        q = deque()
        q.append((root, 0))
        level = 1
        while q:
            root, level = q.popleft()
            if level == len(results):
                results.append([])
            results[level].append(root.val)
            if root.left:
                q.append((root.left, level + 1))
            if root.right:
                q.append((root.right, level + 1))
        # print(results)
        return results




