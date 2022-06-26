"""
Level Order Traversal
Using Queue
We will maintain a queue to store the elements in one level
For every level, we will create a list and put all the nodes from that level in the list and keep adding the children of the nodes processed to the queue
We will also use a size variable to track the  number of elements in that level

Time Complexity = O(n)
Space Complexity = O(n)


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        
        level = 0
        queue = deque([root,])
        while queue:
            levels.append([])
            level_length = len(queue)
            for i in range(level_length):
                node = queue.popleft()
                levels[level].append(node.val)
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                    
                    
            levels+=1
        return levels
                
        
"""
Without queue

We maintain a size variable to track the size of the output(number of lists in the op) and check if size ==current level
if size == current level, it means that we need to add a new level in the op and append the new nodes
for a new incoming node from the same leve, the size will be greater than the level index, and we can keep adding new nodes at that level index to the op 

Time Complexity = O(n)
Space Complexity = O(n)

"""


from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        
        level = 0
        queue = deque([root,])
        while queue:
            levels.append([])
            level_length = len(queue)
            for i in range(level_length):
                node = queue.popleft()
                levels[level].append(node.val)
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                    
                    
            level+=1
        return levels
                
            