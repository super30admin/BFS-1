# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity: O(N)
# Space Complexity: O(H)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if(root is None):
            return []
        results = []
        height = 0
        def traverse(root, height):
            if(len(results) == height):
                results.append([])
            results[height].append(root.val)
            if(root.left is not None):
                traverse(root.left, height+1)
            if(root.right is not None):
                traverse(root.right, height+1)
        traverse(root,height)
        return results
        
        
        