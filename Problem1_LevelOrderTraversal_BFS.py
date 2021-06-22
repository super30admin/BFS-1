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
# O(W): Max stack size is height of the tree. = N/2 nodes 

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
        result = []
        if root = None:
            return result
        queue = []
        queue.append(root)
        while len(queue) > 0:
            size = len(queue)
            li = []
            for i in range(size):
                curr = queue.pop(0)
                li.add(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.add(li)
        return result
    
