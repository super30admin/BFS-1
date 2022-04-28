class Solution:
    def __init__(self):
        self.res = []
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return self.res
        
        self.helper(root, 0)
        return self.res
        
    def helper(self, root, lvl):
        if not root:
            return
        
        if len(self.res) == lvl:
            self.res += [[]]
            
        self.res[lvl] += [root.val]
        
        self.helper(root.left,lvl+1)
        self.helper(root.right, lvl+1)
        
        
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         res = []
        
#         if not root:
#             return res
        
#         queue = [root]
#         lvl = 0
        
#         while queue:
#             l = len(queue)
#             temp = []
            
#             for i in range(l):
#                 node = queue.pop(0)
#                 temp += [node.val]
                
#                 if node.left:
#                     queue += [node.left]
#                 if node.right:
#                     queue += [node.right]
            
#             res += [temp]
#         return res