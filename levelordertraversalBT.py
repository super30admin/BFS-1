# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Accepted on leetcode
#Time Complexity - O(n) as we are traversing through every node
#Space complexity - O(n) for queue

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        #Edge case
        if root == None:
            return result
        queue = []
        queue.append(root)
        while(len(queue) > 0):
            temp = []
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                temp.append(curr.val)
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
            result.append(temp)
        return result