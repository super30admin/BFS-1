# Runs on Leetcode
# Runtime - O(n)
# Memory - O(n)

# Almost same approaches with small changes

        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root):
        if not root:
            return []
        final = []
        queue = [root]
        
        while queue:
            temp = []
            size = len(queue)
            for _ in range(size):
                popped = queue.pop(0)
                temp.append(popped.val)
                if popped.left:
                    queue.append(popped.left)
                if popped.right:
                    queue.append(popped.right)
            final.append(temp)
        return final
