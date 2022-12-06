# Time Complexity: O(N)
# Space Complexity: O(N)->iterative, O(h)->Recursive
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    # BFS Solution
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root==None:
            return list()
        values = list()
        queue = list()
        queue.append(root)

        while len(queue)!=0:
            size = len(queue)
            pres = list()
            for i in range(size):
                curr = queue.pop(0)
                pres.append(curr.val)
                if curr.left==None and curr.right==None:
                    continue
                if curr.left!=None:
                    queue.append(curr.left)
                if curr.right!=None:
                    queue.append(curr.right)
            values.append(pres)
        return values

    # Using DFS
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         def dfs(root,level):
#             if root==None:
#                 return
#             if len(values)-1<level:
#                 values.append([root.val])
#             else:
#                 values[level].append(root.val)

#             dfs(root.left,level+1)
#             dfs(root.right,level+1)
#         values = list()
#         level = 0
#         dfs(root,level)
#         return values

    # Initial Approach
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         if root==None:
#             return []
#         values = list()
#         queue = list()
#         queue.append(root)

#         while len(queue)!=0:
#             pres = []
#             for elem in queue:
#                 pres.append(elem.val)
#             values.append(pres)
#             size = len(queue)
#             for i in range(size):
#                 curr = queue.pop(0)
#                 if curr.left==None and curr.right==None:
#                     continue
#                 if curr.left!=None:
#                     queue.append(curr.left)
#                 if curr.right!=None:
#                     queue.append(curr.right)

#         return values