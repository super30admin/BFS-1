# Time Complexity: O(N)
# Time Complexity: O(2^H) H is the height of the binary tree
# Passed Leetcode 

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if not root:
            return
        out = []
        r_list = [root]
        
        while len(r_list) > 0:
            
            node_list = r_list
            
            out.append(node_list[-1].val)
            
            next_level_list = []
            for node in node_list:
                
                if node.left:
                    next_level_list.append(node.left)
                
                if node.right:
                    next_level_list.append(node.right)
            
            r_list = next_level_list
        return out