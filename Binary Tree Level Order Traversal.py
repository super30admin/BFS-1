""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# BFS-
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        queue = [root]
        if not root:
            return result

        while queue:
            size = len(queue)
            li = []
            for i in range(0, size):
                Tnode = queue.pop(0)
                if Tnode.left != None:
                    queue.append(Tnode.left)
                if Tnode.right != None:
                    queue.append(Tnode.right)
                li.append(Tnode.val)
            result.append(li)
        return result

# DFS-
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         self.helper(root,0)
#         return self.result
#     def helper(self, root, level):
#         if not root:
#             return
#         if len(self.result)==level:
#             self.result.append([])
#         self.result[level].append(root.val)

#         self.helper(root.left, level+1)
#         self.helper(root.right, level+1)


# For printing output [3,9,20,15,7] BFS
# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         result=[]
#         queue=[root]
#         if not root:
#             return result

#         while queue:
#             # size=len(queue)
#             # li=[]
#             # for i in range(0,size):
#             Tnode=queue.pop(0)
#             if Tnode.left!=None:
#                 queue.append(Tnode.left)
#             if Tnode.right!=None:
#                 queue.append(Tnode.right)
#             result.append(Tnode.val)
#             # result.append(li)
#         print(result)
#         return result


