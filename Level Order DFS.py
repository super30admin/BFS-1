# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No    

# Logic:

# Using recursion we go deep down till the leave in tree. while going down we mainain the level for each node.
# this level variable is then used to update the list inside list 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if root==None:
            return None
        res = []
        
        def dfs(root,level):
            #base
            if root==None:
                return
            
            if(level==len(res)):
                res.append([])
            res[level].append(root.val)
            
            dfs(root.left, level+1)
            dfs(root.right, level+1)
        dfs(root,0)
        return res
            
        
        dfs(root, 0)
        
        
        
        