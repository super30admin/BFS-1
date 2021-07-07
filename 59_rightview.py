# S30 Big N Problem #59 {Medium}

# LC - 199. 
# Binary Tree Right Side View

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach
# perform level order traversal 
# at the end of every level, add the last element to the result set


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
        stack=[root]
        
        res=[]
        temp=[]
        while stack:
            length=len(stack)
            
            temp=[]
            for i in range(0,length,1):
                element=stack.pop(0)

                if element.left:
                    stack.append(element.left)
                        
                if element.right:
                    stack.append(element.right)
                        
                temp.append(element.val)
                    
            res.append(temp[-1])
            
        
        return res
                    
                
                    
                        
                        