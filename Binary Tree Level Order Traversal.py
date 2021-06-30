# Definition for a binary tree node.
from collections import deque
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""
BFS Implementation
Time Complexity: O(n)
Space Complexity : ?
"""
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result=[]
        if root==None:
            return result
        queue = deque()      #FIFO implementation in python using deque
        queue.append(root)   #initiate queue using level 0 that is root
        while queue:         #while queue is not empty
            size=len(queue)  #maintaining size variable to process elements level wise,how many at current level
            li=[]            #after processing levels, pushing elements in list first
            for i in range(size): #for loop to process a level
                node=queue.popleft()
                li.append(node.val)
                if node.left!=None: #see if left/right child is present and push them one after other
                    queue.append(node.left)
                if node.right!=None:
                    queue.append(node.right)

            result.append(li) #add the list to resultant list

        return result


"""
DFS Implementation
Time Complexity: O(n)
Space Complexity : O(n)
"""
def dfs_way(self,root,level):
    if root==None:
        return
    #if result and level are equal, that level not processed yet
    #so create a list for that level
    if len(self.result)==level:
        self.result.append(list())

    #if result and level are not equal, that means the level processed already
    #path for it exists in result
    #append the curr node at that level indes in result list
    self.result[level].append(root.val)
    #rescurse left
    self.dfs_way(root.left,level+1)
    #recurse right
    self.dfs_way(root.right,level+1)

def levelOrder(self, root: TreeNode) -> List[List[int]]:
    self.result=[]
    if root==None:
        return self.result

    self.dfs_way(root,0) #start with level 0
    return self.result
