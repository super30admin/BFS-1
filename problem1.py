# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        res = []
        queue = collections.deque()

        queue.append(root)

        size = 1
        while queue:
            level = []
            for i in range(size):
                level.append(queue.popleft())
            res.append([node.val for node in level])
            size = 0
            for node in level:
                if node.left:
                    size += 1
                    queue.append(node.left)
                if node.right:
                    size += 1
                    queue.append(node.right)
        
        return res
            