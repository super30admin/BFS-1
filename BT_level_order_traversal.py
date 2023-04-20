# Time Complexity :O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this problem we conduct a simple BFS to conduct a level-order traversal of the binary tree.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
         #BFS
        if root == None:
            return []

        answer = []
        q= Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            mylist = []
            for i in range(size):
                curr = q.get()
                mylist.append(curr.val)
                if curr.left != None:
                    q.put(curr.left)

                if curr.right != None:
                    q.put(curr.right)

            answer.append(mylist)

        return answer