# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #         bfs
        if (root == None):
            return root
        from collections import deque
        q = deque()
        result = list()
        q.append(root)
        while(len(q) != 0):
            # l = list()
            result.append([])
            qlen = len(q)
            for i in range(qlen):
                curr = q.popleft()
                result[-1].append(curr.val)
                if(curr.left != None):
                    q.append(curr.left)
                if(curr.right != None):
                    q.append(curr.right)
            # result.append(l)
        return result
        
        
#         dfs
#         result = list()
#         self.dfs(root, 0, result)
#         return result
        
#     def dfs(self, root, level, result):
#         if(root == None):
#             return
#         if(level == len(result)):
#             result.append([])
#         result[level].append(root.val)
#         self.dfs(root.left, level + 1, result)
#         self.dfs(root.right, level + 1, result)
        
        
    

            
        
        