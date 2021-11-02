# 102. Binary Tree Level Order Traversal
# https://leetcode.com/problems/binary-tree-level-order-traversal/

# Time Complexiety: O(n)
# Space Complexiety: O(n) (No. elements in the last level (n/2))

# Logic: Take a queue and push into it the node as well as the level. 
# If the current level is different from the previous level, it means that all 
# the nodes of this level are done and we can push into result the temp list. 
# We do this till the queue has elements.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        q = list()
        q.append((root,0))
        prev_lvl = 0
        temp = []
        res = []
        
        while q:
            item, lvl = q.pop(0)
            
            if lvl != prev_lvl:
                res.append(temp)
                temp = []
                prev_lvl = lvl
            
            temp.append(item.val)
            
            if item.left:
                q.append((item.left,lvl+1))
            
            if item.right:
                q.append((item.right,lvl+1))
        
        res.append(temp)
        return res

