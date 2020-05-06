"""

# Problem 3
Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)


"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        q = deque()
        output = []
        q.append(root)
        while q:

            size = len(q)
            for i in range(size):
                if i == size - 1:
                    node = q.popleft()
                    output.append(node.val)
                else:
                    node = q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return output



