# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#BFS
#----------------------------------------

from collections import deque
class Solution:
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if root == None:
            return result
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            last = 0
            for _ in range(size):
                currrent = queue.popleft()
                last = currrent.val
                if currrent.left:
                        queue.append(currrent.left)
                if currrent.right:
                    queue.append(currrent.right)
            result.append(last)
        return result

    
    
    
    
    
 #DFS
#--------------------------------
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        if self.result == None:
            return self.result
        self.helper(root, 0)
        return self.result
            
    def helper(self, root, level):
      
        if(not root):
            return
        if(level == len(self.result)):
            self.result.append(root.val)
        self.helper(root.right, level + 1)
        self.helper(root.left, level + 1)
       

