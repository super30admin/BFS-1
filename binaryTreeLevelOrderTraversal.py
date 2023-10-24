# this one I understood unlike courseSchedule.py
# so we create a queue [which is similar to BFS]
# initially we append the root 
# we iterate over each level , popping left of queue
# we add to poppped result to level and result array
# the childeren of node(left and right) to the queue


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []

        q = collections.deque()
        q.append(root)

        while q :
            qLen = len(q)
            level = []
            while i in range(qLen):
                node = q.popleft()
                if node :
                    level.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
            if level :
                res.append(level)
        
        return res