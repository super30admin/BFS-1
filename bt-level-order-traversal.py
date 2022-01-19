# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Deque


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        li = []

        if root == None:
            return li

        queue = Deque()
        queue.append(root)

        while queue:
            size = len(queue)  # number of elements in the current level
            temp_list = []  # creating a temp list

            for i in range(size):
                curr = queue.popleft()
                # fulfill the current level
                temp_list.append(curr.val)

                # adding child nodes
                if curr.left != None:
                    queue.append(curr.left)

                if curr.right != None:
                    queue.append(curr.right)

            li.append(temp_list)

        return li
