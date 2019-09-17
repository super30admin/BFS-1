# Time Complexity : O(n) 
# Space Complexity : O(k) (Where k is maximum breadth of the tree )
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use queue to traverse using BFS.
# - To seperate every level in the output, keep length of queue in variable and run for loop for only that element.
# - This loop will run only for existing nodes and not run on newly added nodes.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
#       Covering corner case
        if not root:
            return []
#       Initilize Python list. It can be used as a Queue
        q = []
        ans = []
#       Add root into the Queue
        q.append(root)
#       Run this loop till Queue is empty
        while q:
#           Calculate length of Queue
            lq = len(q)
            temp = []
#           Run this loop only for length of Queue
            for i in range(lq):
#               Get first element form the Queue
                current = q.pop(0)
#               Append value to the temp variable
                temp.append(current.val)
#               Check for left node if it exists than add it in the queue
                if current.left:
                    q.append(current.left)
#               Check for right node if it exists than add it in the queue
                if current.right:
                    q.append(current.right)
#           At the end of for loop append temp, It will have nodes in the same level
            ans.append(temp)
        return ans
        
