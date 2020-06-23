"""

    Student : Shahreen Shahjahan Psyche
    Time : O(N)
    Space : O(H)

    This code ran successfully for all the test cases in Leetcode


"""
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    
    # solved the problem using BFS
    def levelOrderBFS(self, root):
        
        from collections import deque
        
        # maintaining a queue to save my nodes and as I want to go level by level, I need to pop the elements in FIFO manner. Thats
        # why I am taking an queue
        records = deque()
        res = []
        records.append(root)
        
        # until my queue gets empty
        while(records):
            size = len(records)
            temp = []
            i = 0
            # as I am interested in to save the values according to the original tree's level thats why I am using a size variable to 
            # keep track
            
            while(i<size):
                element = records.popleft()
                # checking whether left or right childeren is empty. If not I am adding them inside the queue
                if element.left:
                    records.append(element.left)
                if element.right:
                    records.append(element.right)
                temp.append(element.val)
                i += 1
            res.append(temp)
        
        return res
    
    # solved the problem using DFS

    def levelOrderDFS(self, root, level, final):
        
        # eedge case
        if not root:
            return
        
        # Here as we travarse each children with all of its children, we need
        # to keep track of the level. This level defined in which list the 
        # value should get added
        if len(final) == level:
            final.append([])
            final[level].append(root.val)
        else:
            final[level].append(root.val)
        
        level += 1
            
        self.levelOrderDFS(root.left, level, final)
        self.levelOrderDFS(root.right, level, final)
        
        
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        
        if not root:
            return []
        
        final = []
        self.levelOrderDFS(root, 0, final)
        
        return final
        # return self.levelOrderBFS(root)
    
    