# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if root == None:
            return result
        
        queue = deque()
        queue.append(root)
        
        while queue:
            count = len(queue)
            
            for i in range(count):
                element = queue.popleft()
                if i == count-1:
                    result.append(element.val)
                if element.left!=None:
                    queue.append(element.left)
                    
                if element.right!=None:
                    queue.append(element.right)
                    
        return result
        
        
        
        
        
        