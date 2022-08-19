"""
Time Complexity : O(n) both cases
Space Complexity: O(n) both cases
Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None: return None
        res = []
        q = deque()
        q.append(root)
        
        while q:
            _size = len(q)
            temp = []
            
            for i in range(_size):
                curr = q.popleft()
                temp.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                    
            res.append(temp)
            
        return res
        
# Approach - 2

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        """
        using DFS
        """
        res = []
        
        if not root:
            return res
        
        def dfs(root, level):
            # start the current level
            if len(res) == level:
                res.append([])
                
            # append the current node value
            res[level].append(root.val)
            
            #process child nodes for the next level
            if root.left:
                dfs(root.left, level + 1)
            if root.right:
                dfs(root.right, level + 1)
                
        dfs(root, 0)
        return res