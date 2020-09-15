# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 
#Store all nodes in queue level wise
# For every node store it's node left and right

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return
        queue = [root]
        res = []
        nodeCount = 0
        while queue:
            nodeCount = len(queue)
            for i in range(0, nodeCount):
                node = queue.pop(0)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                if nodeCount - 1 == i:
                    res.append(node.val)
        return res
