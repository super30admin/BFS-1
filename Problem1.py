# Problem 1: Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
# Time Complexity: O(n), we visit every node exactly once
# Space Complexity: O(n), the queue holds at most one full level of nodes at a time
# Approach:
# 1. Use a queue to process nodes level by level (left to right)
# 2. At the start of each level, snapshot the queue size,that tells us exactly how many nodes belong to THIS level
# 3. Process only those nodes, collect their values add their children to the queue for the NEXT level

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        # if the tree is empty, nothing to traverse, return empty list
        if root is None:
            return []

        result = []             # result will store our final answer: a list of lists, one per level
        queue = [root]          # seed the queue with just the root node to kick off the traversal
 
        while queue:             # keep going as long as there are nodes left to process

            # freeze the current queue length,this tells us how many nodes are on THIS level, before we start adding next-level children
            size = len(queue)
            temporary = []      # fresh list to collect values for just this level

            # loop exactly 'size' times so we only process THIS level's nodes
            for i in range(size):

                # remove the front node (oldest one added), FIFO order keeps us left-to-right
                current = queue.pop(0)
                temporary.append(current.val)        # save this node's value into the current level's list

                # if a left child exists, add it to the queue, it belongs to the NEXT level
                if current.left:
                    queue.append(current.left)

                # if a right child exists, add it to the queue, also belongs to the NEXT level
                if current.right:
                    queue.append(current.right)
            result.append(temporary)        # done processing this level,save it into our final result

        return result        # queue is empty, all levels processed, return the level-by-level result