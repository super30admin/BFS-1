# Time Complexity : O(n)
# Space complexity : O(n/2)
# Approach:
# Used BFS and traversed each level one after another





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        q = collections.deque()
        
        result = []
        
        q.append(root)
        
        if root == None:
            return root
        
        
        while(len(q)>0):
            
            size = len(q)
            temp = []
            for i in range(0,size):
                
                node = q.popleft() 
                temp.append(node.val)
                
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
                    
    
                
            result.append(temp)
        
        return result
            
            