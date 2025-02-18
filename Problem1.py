# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        self.dfs(root, 0 , result)
        return result

    def dfs(self, root: Optional[TreeNode], level: int ,result: List[List[int]]):
        if root == None:
            return

        if len(result) == level:
            result.append([])
            
        result[level].append(root.val)
        self.dfs(root.left,level+1,result)
        self.dfs(root.right,level+1,result)

        