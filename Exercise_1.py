# Time Complexity: O(n)
# Space Complexity: O(n) -> n is the size of queue
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        
        q = deque([root])
        res = []
        
        while q:
            qlen = len(q)
            r = []
            for i in range(qlen):
                node = q.popleft()
                r.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                    
            res.append(r)
            
        return res