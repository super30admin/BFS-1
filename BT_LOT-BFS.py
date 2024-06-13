# Time Complexity : O(n)
# Space Complexity : O(n)
from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        result = []
        queue = deque([root])
        
        while queue:
            level_size = len(queue)
            level = []
            
            for _ in range(level_size):
                node = queue.popleft()
                level.append(node.val)
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            result.append(level)
        
        return result

# Helper function to build a tree from a list
def buildTree(nodes: List[Optional[int]]) -> Optional[TreeNode]:
    if not nodes:
        return None
    root = TreeNode(nodes[0])
    queue = deque([root])
    i = 1
    while i < len(nodes):
        current = queue.popleft()
        if nodes[i] is not None:
            current.left = TreeNode(nodes[i])
            queue.append(current.left)
        i += 1
        if i < len(nodes) and nodes[i] is not None:
            current.right = TreeNode(nodes[i])
            queue.append(current.right)
        i += 1
    return root

# Example 1
tree1 = buildTree([3, 9, 20, None, None, 15, 7])
sol = Solution()
print(sol.levelOrder(tree1))  # Output: [[3], [9, 20], [15, 7]]

# Example 2
tree2 = buildTree([1, 2, 3, 4, 5])
sol = Solution()
print(sol.levelOrder(tree2))  # Output: [[1], [2, 3], [4, 5]]

# Example 3
tree3 = buildTree([5, 3, 8, 1, None, 7, 9])
sol = Solution()
print(sol.levelOrder(tree3))  # Output: [[5], [3, 8], [1, 7, 9]]
