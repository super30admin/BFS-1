# BFS Approach

from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return [] 
        q = Queue()
        result = []
        q.put(root)

        while not q.empty():
            size = q.qsize()
            temp = []
            for i in range(size):
                curr = q.get()
                temp.append(curr.val)
                if(curr.left != None):
                    q.put(curr.left)
                if(curr.right != None):
                    q.put(curr.right)
            result.append(temp)
        return result






#DFS Approach

# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
#         if root == None:
#             return [] 
#         self.result = []
#         #self.lvl = 0
#         self.dfs(root, 0)
#         return self.result
    
#     def dfs(self, root : Optional[TreeNode] , lvl : int ) ->None:
        
#         #Base Case 
#         if root == None:
#             return

#         if(lvl == len(self.result)):
#             temp = []
#             temp.append(root.val)
#             self.result.append(temp)
#         else:
#             self.result[lvl].append(root.val)
        
#         self.dfs( root.left , lvl + 1)
#         self.dfs( root.right, lvl + 1)