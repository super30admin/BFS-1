# // Time Complexity : O(n) where n is the number of nodes in the graph.
# // Space Complexity : O(n) where n is the number of nodes in the graph.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root == None: 
            return result
        queue = []
        queue.append(root)
        while(len(queue)!= 0):
            size = len(queue)
            temp = []
            for i in range(size):
                node = queue.pop(0)
                temp.append(node.val)
                if node.left != None:   
                    queue.append(node.left)
                if node.right != None:   
                    queue.append(node.right)
            result.append(temp)
        return result
