# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        #DFS
        #O(N)
        #O(h)
        if not root:
            return []
        self.ret = [ ]
        def helper( root, level):
            if root:
                if len(self.ret) == level:
                    self.ret.append([ ]) 
                self.ret[level].append(root.val)
                helper(root.left,  level+1)   
                helper(root.right, level+1) 
        helper(root, 0)
        return self.ret         
        
        #BFS
        #O(N)>>touching every node once
    #O(N)>>adding node in queue
         # if not root:
         #    return []
#         op=[]
#         q=deque()
#         q.append(root)
#         while q:
#             qsize=len(q)
#             level=[]
#             while qsize:
#                 popped=q.popleft()
#                 level.append(popped.val)
                
#                 if popped.left:
#                     q.append(popped.left)
#                 if popped.right:
#                     q.append(popped.right)
#                 qsize-=1
#             op.append(level)
#         return op
            
                    
        
          