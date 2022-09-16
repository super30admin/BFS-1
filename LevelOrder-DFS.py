#TC: O(n)
#SC: O(n)
#Program Ran on Leetcode successfully


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        if root is None:
            return result
        
        self.dfs(root, 0, result)
        return result
    
    def dfs(self, root, depth, result):
        if root is None:
            return
        
        if depth == len(result):
            temp = []
            result.append(temp)
            
        result[depth].append(root.val)
        self.dfs(root.left, depth+1, result)
        self.dfs(root.right, depth+1, result)
            