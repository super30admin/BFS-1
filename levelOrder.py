# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use a queue to perform BFS traversal of the tree level by level.
# For each level, process all nodes currently in the queue, collect their values, and push their children for the next level.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        q = deque()
        res = []
        q.append(root)

        while len(q):
            dup_list = []
            for i in range(len(q)):
                node = q.popleft()
                if node is not None:
                    dup_list.append(node.val)
                if node is not None:
                    q.append(node.left)
                if node is not None:
                    q.append(node.right)
            if dup_list:
                res.append(dup_list)
        return res

        