# Time Complexity : O(n) where n is the maximum element in a list
# Space Complexity : O(w) where w is the max width of the tree / max number of node in any level
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we create a queue and on each level we add all the nodes into the queue
# then we popleft and add the child element of the popped node into the queue
# we iterate until the queue is empty

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:

        if root is None:
            return []

        result = []

        q = deque()

        q.append(root)

        while len(q) != 0:

            temp = []

            qSize = len(q)

            for node in range(qSize):

                current = q.popleft()

                temp.append(current.val)

                if current.left is not None:
                    q.append(current.left)

                if current.right is not None:
                    q.append(current.right)

            result.append(temp)

        return result






