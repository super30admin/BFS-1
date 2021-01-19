# Time Complexity : O(H)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using queue for BST levelOrder traversal. Initialize the queue with root node
# Until queue is not empty, iterate over the queue and pop the root and add the root to a list.
# Then get the left and right child nodes and append it to queue.
# Iterate over the queue to pop the left and right nodes and append it to a new list
# Then append the left and right children to queue and keep on repeating until all are leaf nodes.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return None
        res = []
        queue = ([root])
        while queue:
            levelNodes = []
            for i in range(len(queue)):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                levelNodes.append(node.val)
            res.append(levelNodes)
        return res
