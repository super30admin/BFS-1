# DFS- approach- using stack- recursion

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        depth = 0
        self.dfs(root,result,depth)
        return result
    
    def dfs(self, root, result, depth):
        if root == None:
            return None
        
        if len(result) <= depth:
            result.append([])
        result[depth].append(root.val)
        
        self.dfs(root.left, result, depth+1)
        self.dfs(root.right, result, depth+1)
        
Time complexity- O(N) + O(H)- stack memory      
Space complexity- O(H) for recursion and O(BReadth) for iterartive



# BFS - using queue- iterative 

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        result = []
        q = deque([root])
        
        if root == None:
            return None
        
        
        while q:
            
            level = []
            
            for i in range(0, len(q)):
                
                
                temp = q.popleft()
                
                if temp.left != None:
                    q.append(temp.left)
                    
                if temp.right != None:
                    q.append(temp.right)
                
                level.append(temp.val)
            
            r.append(level[-1])
            result.append(level)
            
        
        return result
