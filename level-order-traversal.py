# Time Complexity: O(n) 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes

from collections import deque
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        res=[]
        level=0
        if root==None:
            return res
        queue=deque([root])

        while queue:
            res.append([])
            level_elements=len(queue)

            for i in range(level_elements):
                popped = queue.popleft()
                res[level].append(popped.val)
                if popped.left: 
                    queue.append(popped.left)
                if popped.right:
                    queue.append(popped.right)
            level+=1

        return res


        