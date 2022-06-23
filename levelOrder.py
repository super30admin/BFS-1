"""
Approach: Recursive traversal

Maintain a results list and for each recursion, check if it has len == level being passed in. If so, add one more empty list to it.
If not, just use that level as index and append current node to it. when we reach end of the recursion, just return the levels.

TC O(N) since each node is processed exactly once
SC O(N) for output datastructure. We can argue it can be ignored, in that case O(1) and whatever stack space is used by the program
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        return self.preOrder(root, 0, [])
        
    def preOrder(self, node, level, levels):
        # we can call this preOrder or convert it to other type of traversal
        # it really just depends on if you are adding node.val to levels array before, between
        # or after the recursive call.
        
        #base 
        # if node reaches none, return levels
        if not node:
            #. we don'tt need to return anything here, see #NOTE below
            return
        
        # if current level and len of levels arr is same, means that we need to add one extra `[]` to levels
        # to allow appending node value to it in the next step.
        if len(levels) == level:
                levels.append([])
        
        levels[level].append(node.val)
        
        # NOTE We are not caring about the return value as levels is passed by reference and whatever modifications
        # are made to levels during the recusion, will persist
        self.preOrder(node.left, level+1, levels)
    
        self.preOrder(node.right, level+1, levels)
        
        # we can safely return levels at the end because it was passed by reference, it would have all the results
        return levels



"""
Approach: Queue approach

TC O(N) each node processed once
SC O(N) for queue = at any point queue will have at most N/2 nodes for a complete BST
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
        result = []
        if not root:
            return []
        
        q = deque()
        # append root
        q.append(root)
        currSize = 1
        while len(q) != 0:
            r = []
            size = currSize  # use new size var for loop
            currSize = 0  # reset currSize to 0
            for i in range(size):
                node = q.popleft()
                r.append(node.val)
                if node.left:
                    currSize +=1 # for every new node we are adding to queue increase currSize
                    q.append(node.left)
                if node.right:
                    currSize +=1
                    q.append(node.right)
            result.append(r)
        print(result)
        return result
                            