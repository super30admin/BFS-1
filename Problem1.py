# Time Complexity: O(N) where N is the max width of the tree
# Spacde Coplexity: O(N)
# Leetcode all test cases passed: Yes
# Any difficulties: No

# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, x):
# #         self.val = x
# #         self.left = None
# #         self.right = None

class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        
        queue = []
        output = []
        
        if root is None:
            return output
        
        queue.append(root)
        
        while len(queue)>0:
            level = []
            for i in range(len(queue)):
                curr = queue.pop(0)
                level.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            output.append(level)
        return output
