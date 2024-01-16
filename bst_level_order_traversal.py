""" Explanation: This code uses a queue to traverse the binary tree level by level. It processes nodes at each 
    level and enqueues their children for the next level. The result list stores the values of nodes
    at each level.
    Time Complexcity: O(n)
    Space Complexcity: O(n)
    TC's ran on LC: Yes
"""

from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
    
        if not root:
            return result

        # Use a queue to perform BFS
        queue = deque([root])

        while queue:
            # Get the number of nodes at the current level
            level_size = len(queue)
            current_level = []

            # Process nodes at the current level
            for _ in range(level_size):
                # Dequeue a node
                node = queue.popleft()
                current_level.append(node.val)

                # Enqueue its children (if any)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            # Add the values of the current level to the result
            result.append(current_level)

        return result