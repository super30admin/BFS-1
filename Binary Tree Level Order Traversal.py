# Time Complexity :
# TC: O(N)

# Space Complexity :
# SC: O(N) --> N/2 --> Number of leaf Nodes

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

# I have used BFS approach to solve this problem.
# I have maintained a queue. 
# and size variable to distinguish between different levels.
# The values of each level is saved in a temp array which is appended in the result array at the end of each level.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # TC: O(N)
    # SC: O(N) --> N/2 --> Number of leaf Nodes
    
    result = []
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        self.result = []
        
        if (root == None):
            return self.result
        
        import queue
        q = queue.Queue()
        q.put(root)
        
        while (not q.empty()):
            
            size = q.qsize()
            temp = []
            
            for i in range(size):
            
                currRoot = q.get()
                temp.append(currRoot.val)
                
                if(currRoot.left is not None):
                    q.put(currRoot.left)
                    
                if(currRoot.right is not None):
                    q.put(currRoot.right)
                    
            self.result.append(temp)
        
        return self.result