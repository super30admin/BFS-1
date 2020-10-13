# Time Complexity: O(N) where N is the max width of the tree
# Spacde Coplexity: O(N)
# Leetcode all test cases passed: Yes
# Any difficulties: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        queue = []
        output = []
        
        if root is None:
            return output
        
        queue.append(root)
        
        while len(queue) > 0:
            level = []
            for i in range(len(queue)):
                curr = queue.pop(0)
                level.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            output.append(level.pop())
        return output
