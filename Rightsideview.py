#TC-o(n)
#SC-o(n)
#Run on leetcode-Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        q=[]
        res=[]
        if(root==None):
            return res
        q.append(root)
        while q:
            size=len(q)
            for i in range(size):
                node=q.pop(0)
                if(i==size-1):
                    res.append(node.val)
                if(node.left!=None):
                    q.append(node.left)
                if(node.right!=None):
                    q.append(node.right)
        return res
    
    
    //////DFS SOLUTION
    # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        q=[]
        self.res=[]
        self.dfs(root,0)
        return self.res
        
    
    def dfs(self,node,depth):
        #base
        if(node==None):
            return self.res
        if(depth==len(self.res)):
            self.res.append(node.val)
        
        
        #Logic
        self.dfs(node.right,depth+1)
        self.dfs(node.left,depth+1)
    
