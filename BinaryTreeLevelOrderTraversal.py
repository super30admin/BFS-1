# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(w), where w is the maximum width of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

from collections import deque
from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.queue = deque() # Intialize a queue to keep track of the nodes at each level
        self.result = [] # Intialize a result list to store the values of nodes at each level

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: # If the root is None, return an empty list
            return self.result
        self.queue.append(root) # Add the root node to the queue to start the level order traversal

        while len(self.queue) > 0: # While there are nodes in the queue, continue the traversal
            size = len(self.queue) # Get the number of nodes at the current level (size of the queue)
            res=[] # Initialize a list to store the values of nodes at the current level
            for i in range(size): # Iterate through the nodes at the current level
                curr = self.queue.popleft() # Remove the current node from the queue
                print(curr.val)
                if curr.left is not None: # If the left child of the current node is not None, add it to the queue
                    self.queue.append(curr.left)
                if curr.right is not None: # If the right child of the current node is not None, add it to the queue
                    self.queue.append(curr.right)
                res.append(curr.val) # Add the value of the current node to the res list for the current level
            self.result.append(res) # After processing all nodes at the current level, add the res list to the result list
        
        return self.result # Return the final result list containing the values of nodes at each level
    
if __name__ == "__main__":
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)

    sol = Solution()
    print(sol.levelOrder(root))