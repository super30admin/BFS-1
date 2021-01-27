# Time Complexity: O(n)
# Space Complexity : O(2^height)
# Approach:
	# Perform a BFS and store the results of one level and append it to the result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        Queue = deque()
        Queue.append(root)
        res = []
        while Queue:
            size = len(Queue)
            temp = []
            for i in range(size):
                currNode = Queue.popleft()
                temp.append(currNode.val)
                if currNode.left:
                    Queue.append(currNode.left)
                if currNode.right:
                    Queue.append(currNode.right)
            res.append(temp)
        return res