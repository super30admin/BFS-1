# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    #Solution 1
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        #Approach: BFS
        #Time Complexity: O(n)
        #Space Complexity: O(n) // deque
        
        result = []
        
        if not root:
            return result
        
        de = deque()
        de.append(root)
        
        while de:
            sz = len(de)    #for level-order traversal
            temp = []
            for i in range(sz):
                popped = de.popleft()
                temp.append(popped.val)
                
                if popped.left:
                    de.append(popped.left)
                if popped.right:
                    de.append(popped.right)
            
            result.append(temp)
        
        return result
    
    #Solution 2
    """
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        #Approach: DFS, recursive
        #Time Complexity: O(n)
        #Space Complexity: O(h) // under the hood
        
        self.result = []
        
        if not root:
            return self.result
        
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root, level):
        #base
        if not root:
            return
        
        #logic
        if level == len(self.result):
            self.result.append([])
        self.result[level].append(root.val)
        
        self.dfs(root.left, level + 1)
        #st.pop()
        self.dfs(root.right, level + 1)
    """