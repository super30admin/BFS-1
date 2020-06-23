# Definition for a binary tree node.

"""

    Student : Shahreen Shahjahan Psyche
    Time : O(N)
    Space : O(N)

    This code ran successfully for all the test cases in Leetcode

"""

# Definition for a binary tree node.

from typing import List
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
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if not root:
            return []
        
        res = self.levelOrderBFS(root)
        final = []
        
        # the intution here is, if I am standing on the right sidee, I can see all the nodes that is in the rightmost position 
        # in eeach level
        for i in range(len(res)):
            final.append(res[i][len(res[i])-1])
            
        return final