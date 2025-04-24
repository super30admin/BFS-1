# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        if not root:
            return []
            
        result = []
        queue = collections.deque([root])
        
        while queue:
            level_size = len(queue)
            current_level = []
            
            for _ in range(level_size):
                current_node = queue.popleft()
                current_level.append(current_node.val)  
                
                if current_node.left:
                    queue.append(current_node.left)
                if current_node.right:
                    queue.append(current_node.right)
            
            result.append(current_level)
        
        return result

#Space Complexity: O(N), where N is the number of nodes in the binary tree due to queue storage

#Time Complexity: O(N), where N is the number of nodes as we visit each node exactly once

