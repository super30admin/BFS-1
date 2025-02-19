# Problem 1 : Binary Tree Level Order Traversal
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import Optional, List
from collections import deque
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []

        # if root is None 
        if root is None:
            return result
        
        # Initialize queue for storing the visited node
        queue = deque([root])
        # loop till queue is empty
        while queue:
            # to store node value at the current level
            levelNode = []

            for _ in range(len(queue)):
                # pop the node from the queue and store in levelNode list
                currNode = queue.popleft()
                levelNode.append(currNode.val)
                # if node has left child then add to the queue
                if currNode.left:
                    queue.append(currNode.left)
                # if node has left child then add to the queue
                if currNode.right:
                    queue.append(currNode.right)
            # append the levelNode list to the resukt list
            result.append(levelNode)
                
        return result
        