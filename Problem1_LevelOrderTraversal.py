'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 102. Binary Tree Level Order Traversal
# Given the root of a binary tree, return the level order traversal of 
# its nodes' values. (i.e., from left to right, level by level).


#-----------------
# Time Complexity: 
#-----------------
# O(N) - Need to iterate over all elements once
#------------------
# Space Complexity: 
#------------------
# O(H): Max stack size is height of the tree. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.result = []
        self.levelOrderHelper(root)
        return self.result
    
    # Use level
    def levelOrderHelper(self, node: TreeNode, height = 0) -> None:
        if node is not None:

            #If the height is equal to length, then index is out of bounds. 
            # So add new empty array to push nodes at this height
            if height == len(self.result):
                self.result.append([])
            self.result[height].append(node.val)
            
            if node.left:
                self.levelOrderHelper(node.left, height+1)
            
            if node.right:
                self.levelOrderHelper(node.right, height+1)