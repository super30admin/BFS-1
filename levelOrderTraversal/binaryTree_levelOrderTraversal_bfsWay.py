'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(n) -- breadth of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
'''
from collections import deque

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        # base
        if root == None:
            return []
        
        # logic
        
        # Declaring queue 
        queue = deque([])
        
        # Declaring resultList
        resultList = []
        count = 0
        
        # Append root to the queue
        queue.append(root)
        
        # Iterate queue
        while len(queue) != 0:
            # get size
            size = len(queue)
            
            if len(resultList) == count:
                
                # index 'count' doesnt exist
                resultList.append([None]*size)
                j = 0
                
                while size != 0:
                    
                    # Dequeue from the queue
                    ele = queue.popleft()
                    
                    # Add val to the resultList
                    resultList[count][j] = ele.val
                    
                    # Add left and right children
                    if ele.left != None:
                        queue.append(ele.left)
                    
                    if ele.right != None:
                        queue.append(ele.right)
                    
                    j +=1
                    size -=1
                
                count +=1
            
        return resultList            
        