#using BFS since we have to do level order traversal and we need to use queue for BFS
# https://leetcode.com/problems/binary-tree-level-order-traversal
# Time Complexity : O(n)
# Space Complexity : O(n/2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root):
        q1 = []
        q2 = []
        self.res = []
        q1.append(root)
        if(root == None):
            return self.res
        return self.switchingQueue(q1, q2, self.res)
    
    def traversal(self, mainQueue, tempQueue, res):
        temp = []
        while(len(mainQueue) != 0):
            node = mainQueue.pop(0)
            if(node != None):
                temp.append(node.val)
                if(node.left != None):
                    tempQueue.append(node.left)
                if(node.right!= None):
                    tempQueue.append(node.right)
        self.res.append(temp)
        return tempQueue
    
    def switchingQueue(self, q1, q2, res):
        while(len(q1) != 0  or len(q2)!=0):
            if(len(q1) != 0):
                q2 = self.traversal(q1, q2, self.res)
            if(len(q2) != 0):
                q1 = self.traversal(q2, q1, self.res)
        return self.res