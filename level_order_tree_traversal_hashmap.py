# Definition for a binary tree node.

# SC : O(N)
# TC: O(N) # Nodes of tree

from typing import List

from pyparsing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result_map = dict()
        
        def traversor(root, level):
            
            if root==None: # if null return 
                return 
            element = root.val
            if level in self.result_map: # check if level is present, then add or create list
                self.result_map[level].append(element)
            else:
                self.result_map[level] = [element]
            
            traversor(root.left, level + 1) # left tree 
            traversor(root.right,level + 1) # right tree
        
        traversor(root, 0) 
        
        return self.result_map.values()
            
            