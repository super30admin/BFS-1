# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:

# BFS
    # def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    #     q = deque()
    #     result = []
    #     q.appendleft(root)
    #     self.helper(root,q,[],result)

    #     return result

    # def helper(self, root, q, curr_list, result):

    #     if root == None :
    #          return
    #     while(len(q) != 0):
    #         size = len(q)
    #         curr_list = []

    #         for i in range(size) :
    #             curr_el = q.popleft()

    #             curr_list.append(curr_el.val)
    #             if curr_el.left != None :
    #                 q.append(curr_el.left)

    #             if curr_el.right != None :
    #                 q.append(curr_el.right)

    #         result.append(curr_list)

    # DFS
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        result = []
        self.dfs(root,0,result)

        return result

    def dfs(self, root, level, result) :
        
        #base
        if root == None:
            return
        #logic
        if len(result) == level :
            result.append([root.val])
        else :
            result[level].append(root.val)

        self.dfs(root.left, level + 1, result)
        self.dfs(root.right, level + 1, result)

        

