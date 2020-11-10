"""
Time complexity O(N)
SPace complexity Asymptotically O(N) in recursive stack
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_dfs:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        level=0
        res=[]
        self.dfs(level,res,root)
        return res

    def dfs(self,level,res,root):
        if not root:
            return 
        if len(res)<=level:
            res.append([])
        res[level].append(root.val)
        self.dfs(level+1,res,root.left)
        #st.pop
        self.dfs(level+1,res,root.right)