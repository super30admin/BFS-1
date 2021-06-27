# BFS and DFS
# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# DFS
# To make the array accessible from both the functions, declare it outside to make it global
result = []

def dfs(root, level):
        # base
        if root is None:
            return None
        # logic
        # If the level is equal to the length of result, create an array at that level
        if level == len(result):
            result.append([])
        
        # Append the value of root to the index of level in the array in both the cases where level is equal to the length of result and also not
        result[level].append(root.val)
        if root.left:
        # Perform dfs on the left and right children (preorder traversal)
            dfs(root.left, level + 1)
        if root.right:
            dfs(root.right, level + 1)
        
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # DFS
        if root is None:
            return None
        
        # call the dfs function with root and level as zero initially
        dfs(root, 0)
        return result
        
    
        
        
# BFS
# from collections import deque
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # Check the none condition
        if root is None:
            return None
        
        # Create a queue using deque
        q = deque()
        # Append root as root exists
        q.append(root)
        # To return an array of arrays, we create an output array and append all the lists to it
        output = []
        
        
        while q:
            # We maintain size variable to know about each level
            size = len(q)
            # Current level array which is created for each level 
            current_level = []
            
            for i in range(size):
                # for each level, we pop the left most element
                current = q.popleft()
                # Append the element into the array for the current level
                current_level.append(current.val)

                # if left exists, add to queue
                if current.left:
                    print("left")
                    q.append(current.left)
                    
                 # if right exists, add to queue
                if current.right:
                    q.append(current.right)
            
            # Append the current level array to the output array
            output.append(current_level)
        
        # return array of arrays
        return output
                
                    
            
            
            
            