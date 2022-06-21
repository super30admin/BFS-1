# time complexity- O(n) where n is the number of nodes
# space complexity - O(n)
from collections import deque


class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        # iterative approach while maintaining the size for each level of tree.
        # initiate queue with root value
        # queue will be maintained with the elements of each level
        # while queue is not empty
        # add empty list to levels
        # append values from the queue to levels based on the level and index
        # pop all elements
        # append elements to the queue
        # increment the level

        levels = []
        if not root:
            return levels

        level = 0
        queue = deque([root, ])
        while queue:
            # append empty list to levels->level[0] will have values of level 0 of the tree.
            levels.append([])

            # find the number of elements that will be there in a level
            level_length = len(queue)

            for i in range(level_length):

                node = queue.popleft()
                levels[level].append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            level += 1
        return levels

