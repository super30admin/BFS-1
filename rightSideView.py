# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        """
        Time Complexity: O(N)
            Traversing N nodes 
        Space complexity: O(N) 
            queue is storing at max leaf nodes bc it is poping elements O(1)
        """
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

                if visited.left: #to check there exist left node or not
                    queue.append(visited.left)
                if visited.right: #to check there exist right node or not
                    queue.append(visited.right)

            result.append(visited.val) #last element of queue for right side 
        
        return result