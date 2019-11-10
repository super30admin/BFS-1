# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Accepted by leetcode
#Time complexity - O(n) because we are travesing through each node
#Space complexity - O(n) we are using extra space queue, result


class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """        
        if root == None:
            return []        
        queue = []
        result = []
        queue.append(root)
        while len(queue) > 0:
            result.append(queue[-1].val)
            size = len(queue)
            for i in range(size):
                node = queue[i]
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            queue = queue[size:]
        return result