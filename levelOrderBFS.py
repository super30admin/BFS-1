# Time Complexity: O(N) : N is the number of nodes in the Tree
# Space Complexity: O(N) : on average where N is the number of nodes

# I use a queue for the BFS traversal. At the current level in the tree, append all the values in the stack


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        result = []

        if root is None:
            return result
        
        self.q = deque()
        self.q.append(root)

        while (len(self.q) > 0):
            size = len(self.q)
            temp = []

            for i in range(size):
                curr = self.q.popleft()
                temp.append(curr.val)

                if(curr.left):
                    self.q.append(curr.left)
                
                if(curr.right):
                    self.q.append(curr.right)
            
            result.append(temp)
    
        return result


