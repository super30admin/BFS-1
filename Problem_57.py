# Time complexity: O(n)
# Space Complexity: O(H) for DFS O(n) for BFS  H is the height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
#         ############### BFS Approach, O(n) time and O(n) space ##################
        
#         result = collections.deque()
#         if not root:
#             return result
#         q = collections.deque()
        
#         q.appendleft(root)
        
#         while q:
#             qsize = len(q)
#             temp = collections.deque()
#             for i in range(qsize):
#                 popped = q.pop()
#                 temp.append(popped.val)
#                 if popped.left:
#                     q.appendleft(popped.left)
#                 if popped.right:
#                     q.appendleft(popped.right)
#             result.append(temp)
        
#         return result

class Solution:
    def __init__(self):
        self.result = collections.deque()
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        ############### DFS Approach, O(n) time and O(h) space ###################
        if not root:
            return self.result
        self.dfs(root,0)
        
        return self.result
    def dfs(self,root,level):
        if not root:
            return
        if level == len(self.result):
            l = collections.deque()
            self.result.append(l)
        self.result[level].append(root.val)
        
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
            