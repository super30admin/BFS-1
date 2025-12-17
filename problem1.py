"""
we implement bfs with deque and print all the nodes in the current level (elements in the queue right now) as 
levels and then append that list to the result list of lists.
TC in O(N) as we have to process all the elements and SC in O(n) for storing the elements in the deque
"""
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        
        res = []
        q = collections.deque()
        q.append(root)

        while q:
            qlen = len(q) #established the len of queue to know how many elements are present in the current level
            level = []
            for i in range(qlen):
                node = q.popleft()
                if node:
                    level.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
            res.append(level)
        return res
