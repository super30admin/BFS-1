# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Is my Time complexity and Space complexity analysis correct? 

#Accepted on Leetcode
#Time complexity - O(N) as we traverse through every node of the tree
#Space complexity - O(N) since we use a queue 

from collections import deque

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        #Edge case
        if root == None:
            return result
        queue = deque()
        queue.append(root)
        while(len(queue) > 0):
            level = []
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                level.append(curr.val)
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
            result.append(level)
        return result