// Time Complexity : O(n) //total no of nodes
// Space Complexity : O(max width at any node)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return None
        
        queue=deque()   
        output=[]
        queue.append(root)    //append root in the queue
        
        while len(queue)>0:  
            output.append([])   //append new list in the output list 
            size=len(queue)
            while size>0: //traverse each level
                size-=1
                n=queue.popleft()   //pop the first node
                output[-1].append(n.val)  //append it in the created new list which is at the end of output list
                if n.left:            //if current node has left then append it in queue
                    queue.append(n.left)  
                if n.right:         //append right node if right node exist
                    queue.append(n.right) 
        return output   //return output list
            
