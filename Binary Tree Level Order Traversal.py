# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# time complexity:O(n)
# space complexity:O(1)

from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]
        if root==None: return result
        
        def dfs(root, lvl):
            #base
            if root==None: return
            #logic
            if len(result)==lvl:
                result.append([])
                
            result[lvl].append(root.val)
            dfs(root.left, lvl+1)
            dfs(root.right, lvl+1)
            
        dfs(root, 0)
        return result
        
        
#         q=Queue()
#         q.put(root)
        
#         while not q.empty():
#             size=q.qsize()
#             li=[]
#             for i in range(size):
#                 curr=q.get()
#                 li.append(curr.val)
                
#                 if curr.left!=None:
#                     q.put(curr.left)
#                 if curr.right!=None:
#                     q.put(curr.right)
                    
#             result.append(li)
#         return result
            