# TC: O(n)
# SC: O(n) 2**H ~ n/2
# We process nodes of level wise. Since we need each level nodes separated, we take size of each level. Use queue to hold nodes at given level. 
# BFS
from collections import deque
class Solution1:
    def levelOrder(self, root):
        res = []
        if root == None: return res
        q = deque()
        # level 0
        q.append(root)
        while q:
            # size of each level
            size = len(q)
            # aux array to hold each level nodes
            temp = []
            for i in range(size):
                # current level nodes will help create array of next level nodes
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            # append each level
            res.append(temp)
        return res

# TC: O(n)
# SC: O(n)
# store level at each node. create empty array in the res array corresponding to its level. append nodes in each level array as and when u encounter node belonging to that level.
# DFS
class Solution2:
    def __init__(self):
        self.res = []
        
    def levelOrder(self, root):
        if root == None: return []
        self.dfs(root, 0)
        return self.res
    
    def dfs(self, root, level):
        # base
        if root == None: return 
        
        # logic
        if level == len(self.res):
            # setting up for child nodes
            self.res.append([])
        # add nodes to corresponding arrays in the result array
        self.res[level].append(root.val)
        # increase level by 1 while processing child nodes
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
        