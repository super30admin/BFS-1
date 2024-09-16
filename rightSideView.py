# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # Idea: In order to traverse tree level by level. Leverage queue data structure to add each level nodes to the queue. While Poppping out the current level nodes, Append the next level and Repeat until whole tree is traversed.
        # Last element of each Level traversal is the element of interest.
        # I have used the same algorithm as BFS to find that element
        
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if not root:
            return []
        output = []
        queue = deque()
        queue.append(root)
        while len(queue) > 0:
            qsize = len(queue)
            for i in range(qsize):
                popped_node = queue.popleft()
                if popped_node.left is not None:
                    queue.append(popped_node.left)
                if popped_node.right is not None:
                    queue.append(popped_node.right)
            output.append(popped_node.val)
        return output
        
        
        
