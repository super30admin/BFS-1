#timecomplexity=O(n)
#space complexity=O(n) because we are mataining queue 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #result=[]
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root==None: return None
        level=0
        self.result=[]
        return self.helper(root,level)
        
        
        
        
        
   #dfs helper going left side first and increasing level++
   # if level and result size same adding new list if greater appending in current list else updating in the level position     
    def helper(self,root,level):
        #base
        if root==None: return
        #logic
        if level==len(self.result):
            templist=[]
            templist.append(root.val)
            self.result.append(templist)
        elif level>len(self.result):
            templist=[]
            templist.append(root.val)
        else:
            self.result[level].append(root.val)
        
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)
        return self.result
            
        
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    """BFS
        if root==None: return
        queue=[]
        queue.append(root) 
        result=[]
        #while loop until queue has element
        size=0
        while queue:
            templist=[]
            size=len(queue)
            for i in range(size):
                r=queue.pop(0)
                templist.append(r.val)
                if r.left: queue.append(r.left)
                if r.right: queue.append(r.right)
            result.append(templist)
       
        return result
                
    """