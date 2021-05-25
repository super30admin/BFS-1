# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return None
        self.result = []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,count):
        if root == None:
            return None
        if count == len(self.result):
            self.result.append(root.val)
        else:
            self.result[count] = (root.val)
        # self.result[count].append(root.val)
        self.dfs(root.left,count+1)
        self.dfs(root.right,count+1)
        
