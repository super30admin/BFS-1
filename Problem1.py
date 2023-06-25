#Time Complexity is: O(n)
#Space complexity is: O(n)
#Code ran successfully on leetcode
#Found no issues while coding

#BFS solution
import collections
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        #If the root is None, we return nothing
        if(root==None):
            return []
        #We are creating an empty result list which will be sent as  final output
        result=[]
        #We are going to implement queue
        de=collections.deque()
        #We are appending the root into the queue
        de.append(root)
        while(len(de)>0):
            #Creating an internal list to store level wise values
            li=[]
            #We will be looping through the queue from 0 to len(de)
            for i in range(0, len(de)):
                #We will be popping current value from the queue
                curr=de.popleft()
                #We will add the popped value to internal list
                li.append(curr.val)
                #We will be adding left and right childs into the queue
                if(curr.left!=None):
                    de.append(curr.left)
                if(curr.right!=None):
                    de.append(curr.right)
            #We will be appending level wise elements into the result array
            result.append(li)
        #We will be finally returning the result array
        return result