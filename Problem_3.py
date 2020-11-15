"""
Time Complexity : O(n)- 
Space Complexity : O(h)- this is space for recursion stack which can be max height of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Here we are using DFS, although it can be done with BFS as well but would require extra queue space.
So here, we are maintaining a local level variable in recursion and every time we are checking
if level equals size of result. If size, that means that level has not been traversed, so we add right value to it.
Otherwise, we dont o anything. We just traverse right value first and then left. Had we traversed left value first,
we had to check that if level is less that size of result, we would have replaced that value with right value.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        if not root:
            return self.result
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, level):
        if not root:
            return
        if level == len(self.result):
            self.result.append(root.val)
        self.dfs(root.right, level+1)
        self.dfs(root.left, level+1)
