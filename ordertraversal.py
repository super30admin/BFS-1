# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Level-order traversal
# Time complexity - O(n) --traversing all nodes
# Space complexity - O(n) -- at max. last level can have n/2 leaf nodes
# Did this solution run on leetcode? - yes

from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # edge case
        if not root:
            return 
        
        # logic
        q = deque([root])
        lvl = -1
        level_order = []
        
        while q:
            lvl += 1
            level_order.append([])
            
            # traverse all nodes in one level
            for _ in range(len(q)):
                node = q.popleft()
                level_order[lvl].append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        
        return level_order


# Using recursion
# Time complexity - O(n)
# Space complexity - O(h)
# Did this solution run on leetcode? - yes
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:    
        # logic
        level_order = []
        
        def rec(node, lvl):
            # base case
            if not node:
                return 
            
            # logic
            if len(level_order)==lvl:
                level_order.append([])
            
            level_order[lvl].append(node.val)
            if node.left:
                rec(node.left, lvl+1)
            if node.right:
                rec(node.right, lvl+1)
            
        rec(root, 0)
        return level_order

