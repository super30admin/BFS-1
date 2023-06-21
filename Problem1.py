'''
Problem: Binary Tree Level Order Traversal
Time Complexity: O(n), where n is number of nodes
Space Complexity: O(n), worst case queue has n/2 nodes
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        used a queue to perform FIFO BFS
        took size to determine the level
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result=[]
        if root is None: 
            return result
        queue = deque()
        queue.append(root)

        while queue:
            size = len(queue)
            #level process
            li =[]
            for i in range(size):
                curr = queue.popleft()
                li.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(li)
        
        return result
