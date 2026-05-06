# Time Complexity : O(n)
# Space complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Got confused while implementing call and storing list for each level.

# Your code here along with comments explaining your approach
# Creating a queue starting with the root node to keep track of nodes to visit.
# Loop through the queue recording its current size to know exactly how many nodes belong to the current level.
# Pop each node for that level from the front, save its value, and add its left and right children to the back of the queue to be processed in the next level.

from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        result = []

        if root is None:
            return []

        q = deque([root])
        while q:
            size = len(q)
            temp = []
            for i in range(0,size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(temp)
        return result 
