# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        result = []
        
        if root == None:
            return result
        
        queue = deque()
        queue.append(root)
        
        while queue:
            count = len(queue)
            levelelements = []
            
            for i in range(count):
                element = queue.popleft()
                levelelements.append(element.val)
                
                if element.left!=None:
                    queue.append(element.left)
                
                if element.right!=None:
                    queue.append(element.right)
            
            result.append(levelelements)
            
        return result
           
                    
                
                
            
                
            
                
                
                
                
        
        
        
        
        