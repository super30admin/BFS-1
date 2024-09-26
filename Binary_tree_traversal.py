BFS traversal
Time complexity:O(n)
space complexity:O(n)
Ran on leetcode:Yes
problems faced: None
Code Description:
we do this using BFS by storing the level of each node at each traversal.when the length of the queue is equal to the level of the node we insert that specific node into the array of the specific level.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution(object):
    def __init__(self):
        self.out=[]
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root==None:
            return []
        queue=deque([[root,0]])
        while (len(queue)!=0):
            q=queue.popleft()
            q_root=q[0]
            count=q[1]
            if count==len(self.out):
                self.out.append([q_root.val])
            else:
                self.out[count].append(q_root.val)
            if q_root.left!=None:
                queue.append([q_root.left,count+1])
            if q_root.right!=None:
                queue.append([q_root.right,count+1])
        return self.out
            
            
Level order recursive order
Time complexity: O(n)
space complexity: O(h) - height of the tree.
Ran on leetcode: Yes
problems faced: None
Code Description: 
we did BFS using recursion where the same logic from the above is implemented by storing the depth of each node.

 # Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution(object):
    def __init__(self):
        self.out=[]
    def helper(self,root,count):
        if root==None:
            return
        if count<len(self.out):
            self.out[count].append(root.val)
        else:
            self.out.append([root.val])
        self.helper(root.left,count+1)
        self.helper(root.right,count+1)
        return self.out
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root==None:
            return
        return self.helper(root,0)
            
            
            
        
            
            
        