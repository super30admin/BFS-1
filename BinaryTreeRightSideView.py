# -*- coding: utf-8 -*-
"""
Created on Sat Oct 17 15:30:15 2020

@author: Tripti Santani
"""

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    '''
    BFS Approach
    
    Step 1: Declare the output list
    Step 2: Check for the base condition if the list is empty, return empty output list
    Step 3: Declare queue which is deque and initialize it with the root(Returns a new deque object initialized left-to-right 
            with data from iterable. If iterable is not specified, the new deque is empty.
            Deques are a generalization of stacks and queues) 
    Step 4: Start a while loop with terminating condition of queue is empty. Store length of queue in q_size 
    Step 5: Start a for loop with range(0,q_size) inside the while loop. We are taking length of queue because 
            for that particular level, q_size will be the total number of nodes present.
    Step 6: Pop the left element from the queue and store it in curr.
    Step 7: In order to append the left and right of the current node, check if the left node is present. If it is
            present, append to the queue. 
            
            Similarly, check if the right node is present, append it to the queue.
    Step 8: Everytime when we are out of the for loop, the value of curr will be the value visible from the right most view.
            Append this value to the output list.
    Step 9: Once out of the while loop, return the output list.
    
    Code accepted in leetcode
    
    Space Complexity - O(W) where W is the maximum width of the tree
    Time Complexity - O(N)
    '''
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        output = []
        
        if root == None:
            return output
        
        queue=deque([root])
        
        while(queue):
            q_size = len(queue)
            
            for i in range(0,q_size):
                curr = queue.popleft()
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            output.append(curr.val)
                    
        return output
                
        
        
        '''
       DFS Approach
       
       Step 1: Declare hash_table for storing the value of the right side view for each level 
               and output for storing the final result
       Step 2: Check base condition if the root is None, return empty output
       Step 3: Define a helper function named dfs. In the helper function, check the base case if root is empty,
               return. In hash_table, if the particular level is present, then append the root value to that
               particular level else add that level as key and root.val as value corresponding to that key
               
               Call the same dfs helper function with parameters(root.left, hash_table, level + 1) and 
               (root.right, hash_table, level + 1) for both left and right sides of the root (Recursive calling)
               
               In the end, return the hash_table
       Step 4: In the rightSideView function, call the dfs function with level = 1 and 
               parameters(root,hash_table,level). It will return the hash_table which will contain the level as
               keys and values are the right side view values.
       Step 5: Append the value from the hash_table for each level into output and return the output
       
       Code accepted in leetcode
       
       Betterment - Can be done without using hash_table
    
    
#     def rightSideView(self, root: TreeNode) -> List[int]:
        
#         hash_table = {}
#         output = []
        
#         # base case
#         if root is None:
#             return output
        
#         level = 1
#         result = self.dfs(root,hash_table,level)
        
#         for key in result:
#             output.append(result[key][0])
            
#         return output
        
#     def dfs(self,root,hash_table,level):
        
#         # base case
#         if root is None:
#             return
        
#         # if level not in hash_table:
#         hash_table[level] = [root.val]
#         # else:
#             # hash_table[level].append(root.val)
            
            
#         self.dfs(root.left, hash_table, level + 1)
#         self.dfs(root.right, hash_table, level + 1)
            
#         return hash_table
            
        '''