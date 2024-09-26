# 102. Binary Tree Level Order Traversal



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        
        res = []
        q = collections.deque()
        
        q.append(root)
        
        while q:
            local = []
            for i in range(len(q)):
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                local.append(curr.val)
            
            res.append(local)
            
            
        return res

# T.C: O(V+E)
# S.C: O(no of level * nof elements in the level)
# Accepted on Leetcode: YES