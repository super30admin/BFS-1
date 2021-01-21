# Created by Aashish Adhikari at 6:10 PM 1/20/2021

'''
Time Complexity:
O(n) as we are reaching each node once

Space Complexity:
O(n/2) since in the worst case, the queue used will have all the elements of the last level.
(Actually O((n/2) + 1) because of the last element from the second-last level)
A complexte binary tree has n/2 elements in the last level.
'''

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

        if root is None:
            return []
        sol = []

        from collections import deque

        q = deque()

        q.append(root)
        size = None

        while len(q) != 0:

            size = len(q)
            current_level = []

            for idx in range(0, size):

                node = q[0]

                current_level.append(node.val)

                if node.left is not None:
                    q.append(node.left)

                if node.right is not None:
                    q.append(node.right)

                q.popleft()


            sol.append(current_level)


        return sol







