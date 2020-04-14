'''
Time and space complexity; O(N)
Challenges: One of the test cases was failing when I used an incorrect operator in if condition.

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root):
         
        # Result list to store the results
        result = []
        
        # Sanity check - if no root, return empty list
        if not root:return result
        
        # Define a function
        def recursive_helper(node, level):
            
            # At the current level/layer, add an extra space to append value
            if len(result) == level:
                result.append([])
            
            # Append the value
            result[level].append(node.val)

            # Next level - left and right nodes
            if node.left:
                recursive_helper(node.left, level + 1)
            if node.right:
                recursive_helper(node.right, level + 1)
        
        # Call the function
        recursive_helper(root, 0)
        return result
