
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
#Time Complexity: O(n)
#Space Complexity: O(n)