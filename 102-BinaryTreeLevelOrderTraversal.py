#Time Complexity : O(n) as each node processed exactly once
# Space Complexity : O(n) to store output at each level
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levelque = deque()
        result = []
        
        if root is None:
            return result
        size = 0
        levelque.append(root)
        while levelque:
        #while len(levelque) != 0:
            size = len(levelque)
            levelList = []
            for i in range(0,size):
                currentNode = levelque.popleft()
                levelList.append(currentNode.val)
                
                if currentNode.left is not None:
                    levelque.append(currentNode.left)
                if currentNode.right is not None:
                    levelque.append(currentNode.right)
            
            result.append(levelList)
        return result
        
            