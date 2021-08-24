"""
//Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        #USING DFS\
        result = []
        if root == None:
            return result
        self.dfs(root,0,result)
        return result
    def dfs(self,root,level,result):
        #base
        if root == None:
            return
        #logic
        
        if level == len(result):
            result.append([])
        result[level].append(root.val)
        self.dfs(root.left,level+1,result)
        self.dfs(root.right,level+1,result)
    
        
        
        
        
#         using BFS
#         from collections import deque
#         if root is None:
#             return None
#         q=deque()
#         q.append(root)
        
#         result = []
#         while len(q)>0:
#             li = []
#             for i in range(0,len(q)):
#                 node = q.popleft()
#                 li.append(node.val)
#                 if node.left!=None:
#                     q.append(node.left)
#                 if node.right!=None:
#                     q.append(node.right)
#             result.append(li)
#         return result
            
                
            
        