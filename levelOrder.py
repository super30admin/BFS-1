
"""
Time Complexity: O(N)
Traversing through each node once

Space Complexity: O(N) returning list of nodes with level. which take space to store O(N) 
Using deque which takes O(1) for pops and append compare to list. 
List takes O(N).

Accepted on leetcode
"""
# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        queue = deque()
        result = []
        
        #root is None return empty
        if root is None:
            return []
        
        #To set head
        queue.append(root)
        
        while queue:
            levels = [] #to add values BT level nodes
            
            for _ in range(len(queue)):
                visited = queue.popleft() # to pop left element and return element, we use popleft
                levels.append(visited.val)
                
                if visited.left: #to check there exist left node or not
                    queue.append(visited.left)
                if visited.right: #to check there exist right node or not
                    queue.append(visited.right)
            
            result.append(levels)
        
        return result