# leetcode:accepted
# time complexity: O(n)
# space complexity: O(n)
# explaination:
"""
Two methods - BFS and DFS
1) in bfs, you do level ordrer traversal and push the elements into the queue and keep a track of the size of the q. you iterate through all the elements of a level that is pushed in the q, and keep a variable size wich keeps track of size of nodes at a particular level. When your i reaches size-1, then you will add the element to the resultant list

2) In DFS method, you keep on iterating towards the right side of the tree. You add the value to the resultant list when the depth of the tree is equal to the size of the tree


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#BFS method
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        queue=[]
        output=[]
        if root==None:
            return output
        queue.append(root)  #ppending the root to the queue
        while(len(queue)!=0):  #you keep on processinguntil ur queue is empty
            size=len(queue)
            for i in range(len(queue)):
                element=queue.pop(0)
                if i==size-1 :  #pushing the last element at each level
                    output.append(element.val)
                if element.left!=None:
                    queue.append(element.left)  #appending the left child
                if element.right!=None:
                    queue.append(element.right)    #appending the right child
        return output

    #BFS almost same method
from collections import deque
class Solution(object):
    def rightSideView(self, root):

        ##BFS
        q=deque()
        result=[]
        if not root:
            return None
        q.append(root)
        while(len(q)!=0):
            size=len(q)
            temp=None
            for i in range(size):
                item=q.popleft()
                value=item.val
                if item.left!=None:
                    q.append(item.left)
                if item.right!=None:
                    q.append(item.right)
            result.append(value)  #you just add the value to the result when your i is terminating
        return result



class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        self.helper(root, result, 0)
        return result

    def helper(self, root, result, depth):
        if not root:
            return None
        if len(result) == depth:
            result.append(root.val)
        self.helper(root.right, result, depth + 1)
        self.helper(root.left, result, depth + 1)


