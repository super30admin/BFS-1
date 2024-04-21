# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        def helper(node, level):
            #base
            if not node:
                return []
            #logic
            if len(res) == level:
                res.append([])
            res[level].append(node.val)
            helper(node.left, level+1)
            helper(node.right, level+1)
        helper(root, 0)
        return res
        
#Time Complexity: O(n)
#Space Complexity: O(n)