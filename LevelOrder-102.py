# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 
#Store all nodes in queue level wise
# For every node store it's node left and right
class Solution(object):
    def levelOrder(self, root):
        
        if root is None:
            return 
        
        queue = [root]
        nodeCount = 0
        ans = []
        
        while queue:
            nodeCount = len(queue)
            res = []
            while nodeCount > 0:
                node = queue.pop(0)
                res.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                nodeCount -= 1
            ans.append(res)
        return ans