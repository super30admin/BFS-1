#Time complexity for put and get: O(n)
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        # DFS solution
        self.result = []
        def dfs(root,level):
            #base
            if root is None:
                return
            #logic
            if len(self.result) == level:
                li = []
                self.result.append(li)
            dfs(root.left,level+1)
            self.result[level].append(root.val)
            dfs(root.right,level+1) 
            
        dfs(root,0)
        return self.result
        
#         BFS solution
#         q = deque([root])
        
#         result = []
        
#         while q:
#             size = len(q)
#             level = []
#             for i in xrange(size):
#                 node = q.popleft()
#                 level.append(node.val)
#                 if node.left is not None:
#                     q.append(node.left)
#                 if node.right is not None:
#                     q.append(node.right)
#             result.append(level)
#         return result
                