#102. Binary Tree Level Order Traversal
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        def dfs(root,level):
            if not root:
                return

            if len(result) == level:
                new_list = []
                result.append(new_list)
            result[level].append(root.val)

            
            dfs(root.left,1+level)
            dfs(root.right,1+level)

        result = []
        dfs(root,0)
        return result
        