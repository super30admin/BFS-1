# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach:
# - Use a queue to traverse the tree level by level, keep a track of the number of nodes in a level using the size of the queue.
# - At every stage, pop out a node and append children of a node for a single level to the queue.
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
        res = []
        q = collections.deque([root])

        while q:
            # Initialize temp list to hold nodes at every level
            temp = []
            # Keep track of the number of nodes in a level
            numnodes = len(q)
            # The inner for loop appends all the children in a level to the queue
            for _ in range(numnodes):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                # Append the node to a temp list
                temp.append(node.val)

            res.append(temp)

        return res
