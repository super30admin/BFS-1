# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        result = []
        
        if not root:
            return result
        
        queue = deque()
        queue.append(root)
        
        ### Breadth First Search
        while queue:
            levelNodes = []
            
            # For nodes at each level
            for i in range(len(queue)):
                node = queue.popleft()
                levelNodes.append(node.val) # Append
                if node.left:
                    queue.append(node.left) # Add left child to queue
                if node.right:
                    queue.append(node.right) # Add right child to queue
                    
            result.append(levelNodes) # Append Level Nodes to result
            
        return result

### Complexity Analysis

# Time Complexity: O(N) --> Number of Nodes (Visiting all Nodes)
# Space Complexity: O(N) --> Number of Nodes (Space Occupied by Queue)