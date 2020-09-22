# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
1. Doing a level order traversal
2. looking for last element in the level and adding them in the result list
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None: return []
        queue = deque([root,])
        result = []
        while queue:
            level_length = len(queue)
            for i in range(level_length):
                node = queue.popleft()
                if i == (level_length - 1):
                    result.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return result