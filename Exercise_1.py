# # Problem 1
# Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :Very Difficult


# // Your code here along with comments explaining your approach

# Recursion
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root):
        # making a list for result
        self.result = []
        # root and height as local variable
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, height):
        # base
        if root is None:
            return
        # Logic
        if height == len(self.result):
            self.result.append([])
        self.result[height].append(root.val)

        self.dfs(root.left, height + 1)
        self.dfs(root.right, height + 1)


sol = Solution()

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.right = TreeNode(6)

print(sol.levelOrder(root))


# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :Very Difficult
# // Your code here along with comments explaining your approach
# BFS Iterative
# from collections import deque
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# class Solution:
#     def levelOrder(self, root):
#         # list of nodes in each level
#         levels = []
#         # if root not present
#         if root is None:
#             # we return empty
#             return levels
#         # creating a queue
#         # with initial value as root
#         queue = deque([root,])
#         # starting with level 0
#         level = 0
#         # till queue is not empty
#         while queue:
#             # making an empty list of list levels = [[]]
#             levels.append([])
#             # size of the queue is number of nodes at each level
#             size = len(queue)
#             # iterating through the size
#             for i in range(size):
#                 curr = queue.popleft()
#                 # appending nodes to respective level
#                 levels[level].append(curr.val)
#                 # if left child present
#                 if curr.left:
#                     # add it to queue
#                     queue.append(curr.left)
#                 # if left child present
#                 if curr.right:
#                     # add it to queue
#                     queue.append(curr.right)
#             level += 1
#         return levels


# sol = Solution()

# root = TreeNode(1)
# root.left = TreeNode(2)
# root.right = TreeNode(3)
# root.left.left = TreeNode(4)
# root.left.right = TreeNode(5)
# root.right.right = TreeNode(6)

# print(sol.levelOrder(root))
