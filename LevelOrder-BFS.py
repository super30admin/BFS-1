#TC: O(n)
#SC: O(n)
#Program Ran on Leetcode successfully

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        
        if root is None:
            return result
        
        queue = []
        queue.append(root)
        
        while (queue):
            size = len(queue)
            temp = []
            for i in range(size):
                curr = queue.pop(0)
                temp.append(curr.val)
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
            
            result.append(temp)
        
        return result