DFS traversal
Time complexity:O(n)
space complexity:O(h) height of the tree.
Ran on leetcode:Yes
problems faced: None.
Code Description:
solved using DFS.stored the depth of node at each node.we are trying to retrive the last element of each level.we do this by starting to traverse to right and then followed by left and by comparing the size of the resultant array with the depth at each and every nodeIf it is equal we add it to the out array.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# DFS traversal
from collections import deque
class Solution(object):
    def __init__(self):
        self.out=[]
    def helper(self,root,count):
        if root==None:
            return
        if count==len(self.out):
            self.out.append(root.val)
        self.helper(root.right,count+1)
        self.helper(root.left,count+1)
        return self.out
        
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root==None:
            return []
        return self.helper(root,0)
        
BFS traversal
Time complexity:O(n)
space complexity:O(n)
Ran on leetcode:Yes
problems faced: None.
Code Description:
we do this problem by storing the last element of each and every level.we get this by traversing through the entire level.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# BFS traversal
from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root==None:
            return []
        out=[]
        queue=deque([[root]])
        while (len(queue)!=0):
            size=len(queue)
            for i in range(size):
                point=queue.popleft()
                value=point[0].val
                if point[0].left!=None:
                    queue.append([point[0].left])
                if point[0].right!=None:
                    queue.append([point[0].right])
            out.append(value)
        return out
            
        
        
