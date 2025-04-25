from collections import deque
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # BFS Approach: Level Order Traversal
    # Time Complexity: O(n) - visits each node once
    # Space Complexity: O(n) - uses a queue to hold nodes per level
    def levelOrder_BFS(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result = []
        queue = deque([root])

        while queue:
            level = []
            for _ in range(len(queue)):  # process current level
                node = queue.popleft()
                level.append(node.val)

                # add children to queue
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            result.append(level)

        print("BFS Level Order Traversal:", result)
        return result

    # DFS Approach: Level Order Traversal using recursion
    # Time Complexity: O(n) - visits each node once
    # Space Complexity: O(h) - height of tree due to recursion stack (O(n) in worst case)
    def levelOrder_DFS(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []

        def dfs(node: TreeNode, level: int):
            if not node:
                return

            # first time reaching this level, create a new list
            if len(result) == level:
                result.append([])

            result[level].append(node.val)

            # recursively visit left and right children
            dfs(node.left, level + 1)
            dfs(node.right, level + 1)

        dfs(root, 0)
        print("DFS Level Order Traversal:", result)
        return result


#      1
#     / \
#    2   3
#   / \
#  4   5

root = TreeNode(1)
root.left = TreeNode(2, TreeNode(4), TreeNode(5))
root.right = TreeNode(3)

sol = Solution()
sol.levelOrder_BFS(root)
sol.levelOrder_DFS(root)
