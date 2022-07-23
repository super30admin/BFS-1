# Time Complexity = O(n)
# Space Complexity = O(n), because of the queue/list being used


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> list[list[int]]:
        if root == None:
            return []
        
        # Declare queue/list and a main list to store the result
        q = []
        result = []
        q.append(root)          # Add the first root to the queue
        
        while q:
            size = len(q)
            miniList = []       # For individual level results
            
            for i in range(size):
                curr = q.pop(0)                 # For popping the first element of the list as lists are FILO and queue is FIFO and we need to implement FIFO using list
                miniList.append(curr.val)       # Add the popped value to the sublist  
                if curr.left != None:
                    q.append(curr.left)         # If valid left child exists, add to the queue
                if curr.right != None:
                    q.append(curr.right)        # If valid right child exists, add to the queue
                    
            result.append(miniList) 
            
        
        return result




