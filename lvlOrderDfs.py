# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC = O(n)
# S.C = O(h)
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        if root is None:
            return result
        
        def dfs ( root, lvl):
            
            # base
            if root is None:
                return
            # logic
            if lvl == len(result):
                result.append([])
            cur_lvl = len(result) - 1
            result[lvl].append(root.val)
            dfs(root.left, lvl + 1)
            dfs(root.right, lvl + 1)
        dfs( root, 0)
        return result
