# Time Complexity : O(v+e) where v is the vertices of the graph and e is the edges
# Space Complexity : O(v+e)
# Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        arr = []
        if root is None:
            return arr

        queue = deque()
        queue.append(root)

        while True:
            size = len(queue)
            data = []

            if size == 0:
                return arr

            while size > 0:

                temp = queue.popleft()
                data.append(temp.val)

                if temp.left is not None:
                    queue.append(temp.left)

                if temp.right is not None:
                    queue.append(temp.right)

                size -= 1

            arr.append(data)
