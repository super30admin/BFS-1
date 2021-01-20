from collections import deque

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#complexity 
#Time - 0(n)
#Space - 0(h)

class Solution: 
    def __init__(self):
        self.result = []
        
    def levelOrder(self, root: TreeNode) -> List[List[int]]:

        if not root:
            return  self.result
        
        self.dfs(root,0)
        
        return self.result
    
    def dfs(self, root, level):
        if not root:
            return
        
        if level == len(self.result):
            self.result.append([])
        self.result[level].append(root.val)
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
        
                
            
'''
result = []
        if not root:
            return  result
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            temp = []
            for i in range(size):
                a = q.popleft()
                if a.left:
                    q.append(a.left)
                if a.right:
                    q.append(a.right)
                temp.append(a.val)
            result.append(temp)
        return(result)

'''          
       
