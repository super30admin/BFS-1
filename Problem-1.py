#Time Complexity :o(n)
#Space Complexity :o(m) m-maximum elements at any level
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        #BFS
        if(root==None):
            return []
        result=[]
        queue=collections.deque()
        queue.append(root)
        
        while(len(queue)!=0):
            size=len(queue)
            arr=[]
            for i in range(size):
                curr=queue.popleft()
                arr.append(curr.val)
                if(curr.left!=None):
                    queue.append(curr.left)
                if(curr.right!=None):
                    queue.append(curr.right)
            result.append(arr)
        return result
        
        
        
        
        #DFS
#         result=[]
#         if(root==None):
#             return []
#         self.dfs(root,0,result)
#         return result
    
#     def dfs(self,root,level,result):
        
#         #base
#         if(root==None):
#             return 
#         #Logic
#         if(level==len(result)):
#             result.append([])
#         result[level].append(root.val)
#         self.dfs(root.left,level+1,result)
#         self.dfs(root.right,level+1,result)
        
        
        
        
        