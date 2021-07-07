
# Binary Tree Right side view -199
# Time complexity -O(N)
# space complexity-O(N)
# Approach : At each level we store the elements in the queue. Based on the size of the queue we append the values to the resultant list. We suppose at nth level right side val is not present then we take the left side value. 



# BFS approach -Level order traversal 
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # level order traversal
        res=[]
        queue=deque()
        #edge case
        if not root: return res
        queue.append(root)
        
        
        while queue:
            size=len(queue)
            for i in range(size):
                curr=queue.popleft()
                temp=curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            res.append(temp)
        return res
            
# left side view

class Solution(object):
    def leftSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # level order traversal
        res=[]
        queue=deque()
        #edge case
        if not root: return res
        queue.append(root)
        
        
        while queue:
            size=len(queue)
            for i in range(size):
                curr=queue.popleft()
                #temp=curr.val
                if i==0:                 # (for getting left side view)
                    temp=curr.val
            
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            res.append(temp)
        return res

    
# DFS approach
# here we maintain a stack and resultant list, if resultant list size is equal to the depth then we append the element to the list. At first we traverse it to right side and then we go to the left side part.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res=[]
        #edge case
        if root==None: return res
        self.helper(root,0,res)
        return res
        
    def helper(self,root,depth,res):
        #edge case
        if not root: return None
        #base case
        if depth==len(res):
            res.append(root.val)
        # we are doing level order traversal from right to left
        if root.right:
            self.helper(root.right,depth+1,res)
        if root.left:
            self.helper(root.left,depth+1,res)
                

                
#BFS -Simple solution
class Solution:
    def rightSideView(self, root):
        
        from collections import deque
        res = []
        if not root: return res
        
        q = deque([root])
        
        while q:
            n = len(q)
            for i in range(n):
                x = q.popleft()
                if i == 0: res.append(x.val)
                if x.right: q.append(x.right)
                if x.left:  q.append(x.left)
        return res
   



            
        