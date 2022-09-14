"""
Time Complexity : O(n) where n is the total number of nodes of given tree
Space Complexity : O(n/2) == O(n) where n is the size of the queue. The actual maximum space consumed by queue at a given time will be number of leaf nodes.

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
Queue is selected for BFS as the time to put the element from  the right end and to get the element from the left end both are O(1) and it is FIFO data structure

1. Append a root to the element and maintain a size variable where size = size of the queue.
   Size actually represents the number of nodes at particular level.
2. Iterate through the queue till size. Everytime we iterate, pop the leftmost element and add its child to the queue.
   Also, create a temp list to store all the elements of that particular level. Add all popped elements to this temp.
3. Add temp to the result after iterator reaches size
4. return result at the end
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
        if root == None: 
            return None
        
        q = Queue()
        q.put(root)
        result = []
        
        while(q.empty() != True):
            size = q.qsize()
            temp = []
            for i in range(size):
                node = q.get()
                temp.append(node.val)
                if node.left != None:
                    q.put(node.left)
                if node.right != None:
                    q.put(node.right)
            result.append(temp)
        
        return result