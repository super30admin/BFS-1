# Binary Tree level order traversal - 102
# Time complexity- O(N)
#space complexity =O(1)
# Approach- Using BFS method, we use queues to store the root values and for processing the level we check the size of the queue.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


from collections import deque

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result=[]
        q=deque()
        #edge case
        if root is None: 
            return result
        else:
            q.append(root)
        while len(q): # check the size of queue
            level=[]
            for _ in range(len(q)):
                curr=q.popleft()
                level.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(level)
        return result
                
        
                