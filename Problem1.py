# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right 

# Time Complexity --> O(n) where n is the number of nodes
# Space Complexity --> O(n/2) 
# Approach --> BFS
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = deque()
        q.append(root)
        result = []
        while q:
            size = len(q)
            temp = []
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right) 
            result.append(temp)
        return result 

'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n) where n is the number of nodes
# Space Complexity --> O(logn) which is the recursive stack size(height of the tree)
# Approach --> DFS
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = []
        self.helper(root, 0)
        return self.result 
    
    def helper(self, root, level):
        # base
        if root is None:
            return

        # logic
        if len(self.result)==level:
            self.result.append([])
        self.result[level].append(root.val)

        self.helper(root.left, level+1)
        self.helper(root.right, level+1)


'''
