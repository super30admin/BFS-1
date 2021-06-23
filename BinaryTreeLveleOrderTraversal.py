# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    """Time complexity-O(n)
    Space Complexity-O(1)"""
    def __init__(self):
        self.arr=[]
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        self.dfs(root, 0)
        return self.arr
    def dfs(self, root, level):
        if not root:
            return
        if len(self.arr)==level:
            self.arr.append([])
        self.arr[level].append(root.val)
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
        
        """Time complexity-O(n)
        Space complexity will be O(n) where we are using dictionary
        for h(i.e. log(n)) keys, in worst case we have 2^h elements for each of the key
        2^h+2^(h-1)+....+1=n"""
            
        # if not root:
        #     return
        # if level not in self.dict:
        #     self.dict[level]=[]
        # self.dict[level].append(root.val)
        # self.dfs(root.left, level+1)
        # self.dfs(root.right, level+1)
        
        
    
    # """Time complexity using BFS is O(n) as traversing through all the nodes
    # Space Complexity-O(n/2) in worst case if its a complete binary tree"""
    # def __init__(self):
    #     self.arr=[]
    # def levelOrder(self, root: TreeNode) -> List[List[int]]:
    #     if not root:
    #         return []
    #     self.bfs(root)
    #     return self.arr
    # def bfs(self, root):
    #     q=deque()
    #     q.append(root)
    #     while len(q)>0:
    #         arr1=[]
    #         for i in range(len(q)):
    #             curr=q.popleft()
    #             arr1.append(curr.val)
    #             if curr.left:
    #                 q.append(curr.left)
    #             if curr.right:
    #                 q.append(curr.right)
    #         self.arr.append(arr1)
    #     return self.arr
    
        
        
            
        
        