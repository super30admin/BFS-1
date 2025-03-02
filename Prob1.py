#  Time Complexity : O(N)
#  Space Complexity : O(N) + O(N/2) = O(N)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : We traverse thorugh the tree. We traverse through each level of the tree and store it in a tempList array. At the end of the for loop we add this array to the res arr. Similarly we add the list of elements at each level to the res array. The res array is the final array.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        
        q = deque()
        q.append(root)
        res = []

        while(len(q) > 0):
            temp = len(q)
            tempList = []

            for i in range(temp):
                tempNode = q.popleft()
                tempList.append(tempNode.val)
                if tempNode.left != None:
                    q.append(tempNode.left)
                if tempNode.right != None:
                    q.append(tempNode.right)
            
            res.append(tempList)
        
        return res