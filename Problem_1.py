"""
Time Complexity : O(n)- as we visit all the nodes once
Space Complexity : O(n)- although its n/2 as in worst case, it will be a complete tree and the number of 
leaf nodes is n/2. But asymptotically, we take it to be n
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


I have done both BFS and DFS solution here and commented the DFS one. For BFS, we maintain a queue and keep 
track of the level by maintaining a variable called size.In every iteration, we check what the size of queue is,
so that we get to know how many nodes we need to process. At every node, we pop an element out of the queue,
put its left and right nodes inside queue and put the node inside result. As we are maintaining size, we are able
to add nodes at a particular level together in a list. For DFS solution, we need to keep track of level in
the local stack. Here, for every node we are checking the length of result list. If length is same as level,
this means that we need to add in a new list inside result as this particular level is being traversed for 
the first time, otherwise we know that this level has been traversed earlier. So, we get the sublist
from result at that particular level, and append the nodes value in that list
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


from collections import deque


class Solution:

    def levelOrder_BFS(self, root: TreeNode) -> List[List[int]]:
        result = []
        if not root:
            return result
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            temp = []
            for i in range(size):
                a = q.popleft()
                if a.left:
                    q.append(a.left)
                if a.right:
                    q.append(a.right)
                temp.append(a.val)
            result.append(temp)
        return(result)
# class Solution:

#     def levelOrder_DFS(self, root: TreeNode) -> List[List[int]]:
#         self.result = []
#         if not root:
#             return self.result
#         self.dfs(root, 0)
#         return self.result

#     def dfs(self, root, level):
#         if not root:
#             return
#         if level == len(self.result):
#             self.result.append([])
#         self.result[level].append(root.val)
#         self.dfs(root.left, level+1)
#         self.dfs(root.right, level+1)
