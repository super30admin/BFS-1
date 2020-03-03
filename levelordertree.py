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
        
        result.append([root.val])
        d = deque()
        d.append(root)
        i = 0
        element = d.popleft()
        res = []
        n = 0
        if element.left!=None:  
            d.append(element.left)
            res.append(element.left.val)
            n = n+1
        if element.right!=None:
            d.append(element.right)
            res.append(element.right.val)
            n = n+1
            
        if res:
            result.append(res)
        
        
        while d:
            count = 0
            l = n
            n = 0
            res = []
            while count < l:
                element = d.popleft()
            
                if element.left!=None:  
                    d.append(element.left)
                    res.append(element.left.val)
                    n = n+1
                if element.right!=None:
                    d.append(element.right)
                    res.append(element.right.val)
                    n = n+1
                 
                count += 1
            
            if res:
                result.append(res)
            
        return result
            
            
                
                
            
            
            
            
            
            
        
        
        
        