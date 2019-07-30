# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # Idea: In order to traverse tree level by level. Leverage queue data structure to add each level nodes to the queue. While Poppping out the current level nodes, Append the next level and Repeat until whole tree is traversed.
        # In order to keep track of current level nodes, as we are updating the queue siultaneously, maintain queue size before adding nodes of next level
        
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if not root:
            return []
        output = []
        queue = deque()
        queue.append(root)
        while len(queue) > 0:
            qsize = len(queue)
            level_nodes = []
            for i in range(qsize):
                popped_node = queue.popleft()
                level_nodes.append(popped_node.val)
                if popped_node.left is not None:
                    queue.append(popped_node.left)
                if popped_node.right is not None:
                    queue.append(popped_node.right)
            output.append(level_nodes)
        return output
        
        
