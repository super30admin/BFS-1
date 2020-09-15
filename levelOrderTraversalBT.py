# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Recursive approach, before class
class Solution:
    
    def __init__(self):
        #maintain a global list of levels
        self.levels = []
    
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return self.levels
        
        #make recursive call
        self.recur(root, 0)
        
        return self.levels
        
        
    def recur(self, root:TreeNode, level):
        
        #keep appending to the levels list as you encounter another node in the level
        if len(self.levels) == level:
            self.levels.append([])
            
        self.levels[level].append(root.val)
        
        if root.left:
            self.recur(root.left, level+1)
        if root.right:
            self.recur(root.right, level+1)
            
        
        