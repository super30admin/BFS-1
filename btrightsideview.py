# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Iterative solution
# Time complexity - O(n)
# Space complexity - O(n) for queue
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return 
        rightNodes = []
        level_order = deque([root])
        
        while level_order:
            for _ in range(len(level_order)):
                node = level_order.popleft()
                if node.left:
                    level_order.append(node.left)
                if node.right:
                    level_order.append(node.right)
            # append the right most node.
            rightNodes.append(node.val)
        
        return rightNodes

# Recursion
# Time complexity - O(n)
# Space complexity - O(h) recursive stack length will be the height of the tree - max O(n)
# Did this solution run on leetcode? - yes
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:    return
        rightNodes = []
        
        def dfs(node, lvl):
            if lvl == len(rightNodes):
                rightNodes.append(node.val)
            # check if the right child exists.
            if node.right:
                dfs(node.right, lvl+1)
            # check if the left child exists.
            if node.left:
                dfs(node.left, lvl+1)
    
        dfs(root, 0)
        return rightNodes
        
    