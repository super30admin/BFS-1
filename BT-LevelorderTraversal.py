# // Time Complexity :O(n+m)
# // Space Complexity :O(n+m)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :no
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        queue = deque()
        queue.append(root)
        answer = []
        while queue :
            level_size = len(queue)
            level = []
            while level_size > 0:
                # print(queue)
                tmp_node = queue.popleft()
                level.append(tmp_node.val)
                if tmp_node.left:
                    queue.append(tmp_node.left)
                if tmp_node.right:
                    queue.append(tmp_node.right)
                level_size -= 1
            answer.append(level)
        return answer