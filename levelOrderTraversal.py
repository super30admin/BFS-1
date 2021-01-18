# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        """
            - need to return a list
            can use a queue that initially has the root..cause BFS
            While queue is not empty:
                - populate curr[] that has the nodes at that level.
                - put the curr[] into res[] 
                - populate queue
        """
        res = []
        
        if not root:
            return res
        
        queue = deque([root])
        
        while queue:
            size = len(queue)
            curr = []
            
            for i in range(0, size):
                node = queue.popleft()
                
                if i == size - 1:
                    res.append(curr)
                    
                curr.append(node.val)
                
                if node.left:
                    queue.append(node.left)  
                if node.right:
                    queue.append(node.right)         
        return res
            
            