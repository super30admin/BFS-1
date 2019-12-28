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
        
        final_list = [None] * 10000
        level = 0
        queue = [root]
        while queue:
            size = len(queue)
            level_list = []
            for i in range(size):
                element = queue.pop(0)
                level_list.append(element.val)
                if element.left:
                    queue.append(element.left)
                if element.right:
                    queue.append(element.right)
            final_list[level] = level_list
            level += 1
            
        for f in range(len(final_list)):
            if final_list[f] is None:
                del final_list[f:]
                break
                
        return final_list
        

class Solution:
    def helper(self,root):
        final = []
        current =  [root]
        while current:
            values = []    
            level = []
            for i in current:
                values.append(i.val)
                if i.left:
                    level.append(i.left)
                if i.right:
                    level.append(i.right)
            current = level
            final.append(values)
        return final
        
    def levelOrder(self, root):
        if not root:
            return []
        return self.helper(root)
