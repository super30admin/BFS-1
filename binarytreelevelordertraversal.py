#Approach : DFS
#Time Complexity: O(h)
#Space Complexity: O(h)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Using DFS
from collections import deque
class Solution:
    
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None: return []
        q = deque()
        q.append(root)
        result = []
        self.dfs(root,0,result)
        return result
    
    def dfs(self, root: Optional[TreeNode], level:int,result:List[int])->None:
        #base
        if root == None: return
        
        #logic
        if level == len(result):
            result.append(list())
        result[level].append(root.val)
        self.dfs(root.left,level+1,result)
        self.dfs(root.right,level+1,result)
