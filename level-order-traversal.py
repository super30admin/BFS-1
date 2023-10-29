# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach 1: # BFS
# Create a queue, store left and right child of each discovered node in the queue to keep track of the next level as you pop the nodes after visiting and append it to result.
# TC: O(n/2) = O(n), SC: O(n) for queue
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        if root == None:
            return []

        result = []

        q = []  # create queue
        q.append(root)  # push root as first element in the queue

        # you should keep processing the nodes until queue is empty
        while len(q) > 0:
            temp = []
            # initially when you start, there'll be only # of elements belonging to a single level in the queue. You will loop through all those elements, pop them out in FIFO fashion, find their left and right child and append to the queue. Eventually when you finish looping all those elements that you began with, you will finish with the level which means append to result.
            for i in range(len(q)):
                node = q.pop(0)  # remove first element from queue since FIFO
                # print(node)
                temp.append(node.val)
                # print(temp)
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
            result.append(temp)
            # print(result)
        return result

# Approach 2:  DFS
# TC: O(n), SC: O(h) where h is height of recursion stack
        # def helper(root, level):
        #     # base
        #     if root == None:
        #         return

        #     # if # if len of result is equal to level #, that means list for that level doesn't exist in result. So create it
        #     if level == len(res):
        #         res.append([])

        #     # print("UP", root.val)
        #     res[level].append(root.val)
        #     helper(root.left, level+1)

        #     helper(root.right, level+1)

        #     # print(" DOWN", root.val)

        # res = []
        # helper(root, 0)
        # return res
