"""
Time complexity: O(N)
Space complexity: O(N) Space taken by the bfs queue, which is level containing max number of nodes
Compiled on leetcode?: Yes
"""
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if not root:
            return result
        queue = deque()
        queue.append(root)
        
        while queue:
            size = len(queue)
            for i in range(size):
                currentNode = queue.popleft()
                if i == size - 1:
                    result.append(currentNode.val)
                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right:
                    queue.append(currentNode.right)
        return result  