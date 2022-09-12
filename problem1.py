'''
102. Binary Tree Level Order Traversal

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(1)
LEETCODE: Yes
DIFFICULTIES: A bit, I managed it. Before the class.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if root == None:
            return res
        elif root.left == None and root.right == None:
            return [[root.val]]
        
        res.append([root])
        
        i = 0
        n = len(res)
        go_ahead = True
        
        while go_ahead:
            temp = []
            for j in range(0, len(res[i])):
                node = res[i][j]
                if node.left != None:
                    temp.append(node.left)
                if node.right != None:
                    temp.append(node.right)
                res[i][j] = node.val
            if len(temp) == 0:
                go_ahead = False
            else:
                res.append(temp)
                i += 1
            
        return res
        
