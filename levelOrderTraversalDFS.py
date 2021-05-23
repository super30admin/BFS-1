# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root is None:
            return None
        
        self.dfs(root,0)
        
        return self.result
        
    def dfs(self, root: TreeNode, height:int):
        
        if root is None:
            return None
        
        if height == len(self.result):
            self.result.append(list())
            
        self.result[height].append(root.val)
        
        self.dfs(root.left, height+1)
        self.dfs(root.right, height+1)
        
        
#  this is the dfs solution to the problem. basically putting all values in the stack and then popping one by one and adding a list depending on level.
#  time complexity is O(n) and space complexity is O(h)
        
        
        
        
        
