"""
Name: Srinidhi 
Did it run on LC: Yes

Time Complexity: O(n) - Exploring all nodes
Space Complexity: O(n) - Output Structure contains all nodes

Logic - Do a level order traversal. 
During the traversal, at each layer return the last node of the layer
This will give the right side view
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        ans = []
        
        qu = [root]
        
        while qu:
            
            level_len = len(qu)
            
            for i in range((level_len)):
                node = qu.pop(0)
                if i == level_len - 1:
                    ans.append(node.val)
                
                if node.left:
                    qu.append(node.left)
                
                if node.right:
                    qu.append(node.right)
        
        return ans
                