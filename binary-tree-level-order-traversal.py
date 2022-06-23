# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    #BFS
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]: 
        self.result=[]
        if root==None: return self.result
        from collections import deque
        q=deque()
        q.append(root)
        while len(q)!=0:
            lis=[]
            for i in range(len(q)):
                temp=q.popleft()
                lis.append(temp.val)
                if temp.left!=None: q.append(temp.left)
                if temp.right!=None: q.append(temp.right)
            self.result.append(lis)            
        return self.result
    # #DFS
    # # Time Complexity: O(n)
    # # Space Complexity: O(h)
    # def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]: 
    #     self.result=[]
    #     if root==None: return self.result
    #     self.dfs(root,0)
    #     return self.result          
    # def dfs(self, root: Optional[TreeNode], level:int):
    #     if root==None: return
    #     if len(self.result)==level:
    #         self.result.append([])
    #     self.result[level].append(root.val)
    #     self.dfs(root.left,level+1)
    #     self.dfs(root.right,level+1)
    
        
        
        