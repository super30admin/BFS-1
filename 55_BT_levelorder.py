# S30 Big N Problem #55 {Easy}

# LC - 102. 
# Binary Tree Level Order Traversal

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(n) n=no. of nodes in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# traverse the tree from root node. push the left and right nodes to stack
# elements in the stack at every loop represents level of the tree
# accordingly store the values in an result array 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root is None:
            return []
        stack=[root]
        res=[]
        
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
            
            res.append(temp)
            
        return res
                
                
        