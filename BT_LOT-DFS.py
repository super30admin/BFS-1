# Time Complexity : O(n)
# Space Complexity : O(n)
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.result = []

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        self._dfs(root, 0)
        return self.result

    def _dfs(self, node: TreeNode, level: int):
        if not node:
            return
        if level == len(self.result):
            self.result.append([])
        self.result[level].append(node.val)
        self._dfs(node.left, level + 1)
        self._dfs(node.right, level + 1)

# Helper function to build a tree from a list
def buildTree(nodes: List[int]) -> TreeNode:
    if not nodes:
        return None
    root = TreeNode(nodes[0])
    queue = [root]
    i = 1
    while i < len(nodes):
        current = queue.pop(0)
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
print(sol.levelOrder(tree1))  # Output: [[3], [9], [20], [15], [7]]

# Example 2
tree2 = buildTree([1, 2, 3, 4, 5])
sol = Solution()
print(sol.levelOrder(tree2))  # Output: [[1], [2, 3], [4, 5]]

# Example 3
tree3 = buildTree([5, 3, 8, 1, None, 7, 9])
sol = Solution()
print(sol.levelOrder(tree3))  # Output: [[5], [3, 8], [1, 7, 9]]