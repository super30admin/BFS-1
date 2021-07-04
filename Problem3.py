# Time Complexity : O(n) 
# Space Complexity : O(k) (Where k is maximum breadth of the tree )
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use queue to traverse using BFS.
# - To seperate every level in the output, keep length of queue in variable and run for loop for only that element.
# - Append element only if we are on the last node of current level

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
#       Covering corner case
        if not root:
            return []
        q = []
        ans = []
#       Add root into the Queue
        q.append(root)
#       Run this loop till Queue is empty
        while q:
#           Calculate length of Queue
            lq = len(q)
#           Run this loop only for length of Queue
            for i in range(lq):
#               Get first element form the Queue
                current = q.pop(0)
#               Append node to the answer only if It is the last element from the current level of the tree.
                if i == lq - 1:
                    ans.append(current.val)
#               Check for left node if it exists than add it in the queue
                if current.left:
                    q.append(current.left)
#               Check for right node if it exists than add it in the queue
                if current.right:
                    q.append(current.right)
        return ans
