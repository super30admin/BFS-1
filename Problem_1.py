#
# @lc app=leetcode id=102 lang=python3
#
# [102] Binary Tree Level Order Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity - O(n). We traverse each and every node of the Tree for DFS and O(n) + O(h) for DFS
Space Complexity - O(n). We are using a queue where at the worst case we will have (n/2) nodes i.e. nodes at last level.
                   O(n) for DFS as well.

This code works on Leetcode
'''
from collections import deque
class Solution:
    def __init__(self):
        self.levelMap = {}

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        # USING BFS
        nodeQ = deque() #create Queue
        nodeQ.append(root) #add the root to the queue
        while nodeQ:
            qlen = len(nodeQ) #before processing the queue find size of queue. We are doing this to distinguish between levels
            level = [] #create a list for each level
            for i in range(qlen):
                currNode = nodeQ.popleft() #takeout the first element from the queue for processing
                if currNode: #if node is not null 
                    level.append(currNode.val) #add the value to the level list
                    nodeQ.append(currNode.left) #add the left children to the list first
                    nodeQ.append(currNode.right) #Then add all the right children to the list
            if level: #if we have a node in the list, append the list to the result
                result.append(level)
        # USING DFS
        # self.helper(root, 0)
        # lvl = 0
        # while lvl in self.levelMap: #for every level get the nodes until we find a level that does not exist
        #     result.append(self.levelMap.get(lvl)) #add all the nodes to the result
        #     lvl+=1 #increment level to access next nodes
        return result #finally return the result
    
    def helper(self, root, currLvl):
        if root == None: #return if root is null
            return
        if currLvl not in self.levelMap: #if this is the first element at that particular level
            self.levelMap[currLvl] = []
        lvlNodes = self.levelMap.get(currLvl) 
        lvlNodes.append(root.val) #else add that element to the corresponding level
        self.helper(root.left, currLvl+1) #traverse left, going down by 1 level hence current level + 1
        self.helper(root.right, currLvl+1) #traverse right, going down by 1 level hence current level + 1

    
        
# @lc code=end

