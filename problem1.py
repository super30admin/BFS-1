#Time , space complexity O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.res=[]
        self.dfs(root,0)
        return self.res
 #Dfs traversal   
    def dfs(self,root,h):
        if root == None:
            return None
    #At each level creating empty list and appending values    
        if len(self.res) == h:
            self.res.append([])
        self.res[h].append(root.val)
        
        self.dfs(root.left,h+1)
        self.dfs(root.right,h+1)
