# // Time Complexity :O(N)
# // Space Complexity :O(N)..All leaf nodes(n/2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# Use queue so that  you wont miss level, make sure to check if node is valid before add ing to queue dont add None






# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue=deque()
        ans=[]
        queue.append(root)
        while(queue):
            l=len(queue)
            temp=[]
            while(l>0):
                node=queue.popleft()
                if node:
                    temp.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
                l-=1
            if temp:
                ans.append(temp)
        return ans

        
