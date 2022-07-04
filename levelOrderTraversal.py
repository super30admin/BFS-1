#Time Complexity:O(n)
#Space Complexity: O(h)

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]
        if root==None:
            return result
        q=collections.deque()
        q.append(root)
        
        while len(q)!=0:
            size=len(q)
            li=[]
            for i in range(size):
               
                curr=q.popleft()
                li.append(curr.val)
                if curr.left!=None:
                    q.append(curr.left)
              
                if curr.right!=None:
                    q.append(curr.right)
                
            result.append(li)
        return result

#Time Complexity:O(n)
#Space Complexity: O(1), Recursive stack space O(h) 

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result=[]
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level): #3,0, 9,1, 20,1
        if root==None:
            return 
        if len(self.result)<=level: #len=0,level=0, len=1,level=1, len=2,level=1
            self.result.append([root.val]) #result=[[3],[9]]
        else:
            self.result[level].append(root.val)
        self.dfs(root.left,level+1)#dfs(9,1), dfs(none,2)
        self.dfs(root.right,level+1)#dfs(20,1)
            
            
            
       
