# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# Using deque
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.result = []
        self.count = 0

    def levelOrder(self, root):
        count = 0
        self.queue = deque()
        self.queue.append(root)
        while len(self.queue) != 0:
            size = len(self.queue)
            self.result.append([0] * size)
            for i in range(size):
                pop = self.queue.popleft()
                if pop.left:
                    self.queue.append(pop.left)
                if pop.right:
                    self.queue.append(pop.right)
                self.result[count][i] = pop.val
            count += 1
        return self.result


check = TreeNode(1)
check.left = TreeNode(2)
check.right = TreeNode(3)
check.left.left = TreeNode(4)
check.left.right = TreeNode(5)
print(Solution().levelOrder(check))

# Using stack as Queue.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def __init__(self):
#         self.result = []
#         self.count = 0

#     def levelOrder(self, root):
#         if root is None:
#             return
#         count = 0
#         self.queue = [root]
#         while len(self.queue) != 0:
#             size = len(self.queue)
#             self.result.append([0]*size)
#             for i in range(size):
#                 pop = self.queue.pop(0)
#                 if pop.left:
#                     self.queue.append(pop.left)
#                 if pop.right:
#                     self.queue.append(pop.right)
#                 self.result[count][i] = pop.val
#             count += 1
#         return self.result
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(3)
# check.left.left = TreeNode(4)
# check.left.right = TreeNode(5)
# print(Solution().levelOrder(check))


# Using DFS
# TC - O(n); SC - O(n)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.result = []
#
#     def helper(self, root, level):
#         if root is None:
#             return
#         if len(self.result) == level:
#             self.result.append([])
#             self.result[level] = [root.val]
#         elif len(self.result) >= level + 1:
#             self.result[level].append(root.val)
#         self.helper(root.left, level + 1)
#         self.helper(root.right, level + 1)
#
#     def levelOrder(self, root):
#         self.helper(root, 0)
#         return self.result
#
#
# check = TreeNode(1)
# check.left = TreeNode(2)
# check.right = TreeNode(3)
# check.left.left = TreeNode(4)
# check.left.right = TreeNode(5)
# print(Solution().levelOrder(check))
