# https://leetcode.com/problems/binary-tree-level-order-traversal/

# BFS solution
# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        q = deque()
        res = []

        q.append(root)
        while len(q) > 0:
            size = len(q)
            new_list = []

            for i in range(size):
                qroot = q.popleft()
                new_list.append(qroot.val)

                if qroot.left is not None:
                    q.append(qroot.left)

                if qroot.right is not None:
                    q.append(qroot.right)
        
            res.append(new_list)

        return res
    

# DFS Solution

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
        self.res = []
        self.helper(root, 0)
        return self.res

    def helper(self, root, depth):
        if root is None:
            return 
        if depth == len(self.res):
            new_list = []
            self.res.append(new_list)
            
        self.res[depth].append(root.val)
        
        self.helper(root.left, depth + 1)
        self.helper(root.right, depth + 1)