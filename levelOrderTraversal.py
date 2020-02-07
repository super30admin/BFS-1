"""
Time Complexity: O(N)
Space Complexity: O(N) (Max number of nodes in a level which has to be stored in a queue)
Compiled on leetcode: Yes
Difficulties faced: No
"""
from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if not root:
            return result
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            levelArray = []
            for i in range(size):
                currentNode = queue.popleft()
                levelArray.append(currentNode.val)
                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right:
                    queue.append(currentNode.right)
            result.append(levelArray)
        return result   

