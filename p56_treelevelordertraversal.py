"""
https://leetcode.com/problems/binary-tree-level-order-traversal/
Approach: we follow breadth first search first making a doubly ended queue and dequeing values in the range of size of
the queue so that we stick to processing of that particular level.
Tc: O(n)
SC:O(n) using queueauxilary data structure

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

from collections import deque


class Solution:
    def levelOrder(self, root):
        result = []
        if root == None:
            return result
        queue = deque()
        queue.append(root)

        while not len(queue) == 0:
            size = len(queue)
            temp = []
            for i in range(size):
                current = queue.popleft()
                temp.append(current.val)
                if current.left != None:
                    queue.append(current.left)
                if current.right != None:
                    queue.append(current.right)
            result.append(temp)
        #
        # print(queue)

        return result


