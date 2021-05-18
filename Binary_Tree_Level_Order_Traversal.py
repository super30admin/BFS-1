from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #BFS_approach
    def levelOrder_B(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
        
        q = deque()
        
        q.append(root)
        result = []
        while q:
            size = len(q)
            level_list = []
            for _ in range(size):
                node = q.popleft()
                level_list.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            result.append(level_list)
        
        return result
            
            
    #DFS approach:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
    
        self.result = []
        self.dfs(root,0)
        return self.result
    
    
    def dfs(self,root,lvl):
        
        #base
        if not root:
            return
        
        #logic
        if lvl == len(self.result):
            self.result.append([])
        
        self.result[lvl].append(root.val)
        self.dfs(root.left,lvl+1)
        self.dfs(root.right,lvl+1)
        
        
