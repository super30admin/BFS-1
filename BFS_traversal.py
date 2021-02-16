################## Iterative solution
# Time complexity: O(n)
# Space complexity: O(n)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses a queue. Iteratively, it pops the queue with the root node, and appends the
# queue with the child nodes.


class Solution:
    def levelOrder(self, root):
        queue = deque([])
        queue.append(root)
        result = []

        if root == None: return None
        while (len(queue) != 0):

            temp_list = []

            for i in range(len(queue)):
                current_node = queue.popleft()
                temp_list.append(current_node.val)

                if current_node.left != None: queue.append(current_node.left)
                if current_node.right != None: queue.append(current_node.right)
            result.append(temp_list)

        return result


# Recursive approach: # Time complexity: O(n)
# # Space complexity: O(n)
# # Worked on leetcode: yes
# # Iterative approach: This algorithm uses a queue. Iteratively, it pops the queue with the root node, and appends the
# # queue with the child nodes.

from collections import deque


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def levelOrder(self, root):
        self.result = []

        if root == None: return None
        self.helper(root, 0)

        return self.result

    def helper(self, root, height):
        if root == None: return

        if height == len(self.result): self.result.append([])
        self.result[height].append(root.val)

        self.helper(root.left, height + 1)
        self.helper(root.right, height + 1)
