# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        ## DFS solution
        ## T.C = O(n)
        ## S.C = O(h) h => height
        
        res = []
        
        def dfs(root, lvl):
            if not root:
                return
            
            if lvl == len(res):
                res.append([])
            
            res[lvl].append(root.val)
        
            dfs(root.left, lvl + 1)
            dfs(root.right, lvl + 1)
        
        dfs(root, 0)
        return res
        
        ###############################
        ## BFS solution
        ## T.C = O(n)
        ## S.C = O(n/2) ~ O(n)
        
        if not root:
            return []
        
        q = [root]
        res = []
        
        while q:
            tmp = []
            
            for i in range(len(q)):
                node = q.pop(0)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                tmp.append(node.val)
                
            res.append(tmp)
        
        return res
        

            
            