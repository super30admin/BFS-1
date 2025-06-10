# Definition for a binary tree node.
from typing import Optional,List,Deque
import collections
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         res = []
#         q = collections.deque()
#         if not root : return res
#         q.append(root) #add to the queue
#         while q:
#             # create a list of nodes in a level and size to know distinct elements
#             li = []
#             size = len(q)
#             for i in range(size): #iterate and add all children and add unique in list
#                 node = q.popleft()
#                 li.append(node.val)
#                 # add children
#                 if node.left:
#                     q.append(node.left)
#                 if node.right:
#                     q.append(node.right)
#             # end of level add the li to res
#             res.append(li)
#         return res


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         res = []

#         def dfs(root, level, res):
#             # base
#             if not root : return None

#             # logic
#             if len(res) == level:
#                 res.append([])
#             res[level].append(root.val)
#             dfs(root.left,level+1,res)
#             dfs(root.right,level+1,res)


#         dfs(root, 0, res)
#         return res
        

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []

        def dfs(root, level, res):
            # base
            if not root : return None

            # logic
            if len(res) == level:
                res.append([])
            li = res[level]
            li.append(root.val)
            dfs(root.left,level+1,res)
            dfs(root.right,level+1,res)


        dfs(root, 0, res)
        return res
        
        