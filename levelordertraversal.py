# Time complexity: O(n)
# Space complexity: O(n) - > n is the max of leaf nodes in the worst case

from collections import deque
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
            return []
        queue = deque()
        queue.append(root)
        result = []
        while queue:
            currlevel = []
            for i in range(len(queue)):
                poppedElement = queue.popleft()
                currlevel.append(poppedElement.val)
                if poppedElement.left:
                    queue.append(poppedElement.left)
                if poppedElement.right:
                    queue.append(poppedElement.right)
            result.append(currlevel)
        return result