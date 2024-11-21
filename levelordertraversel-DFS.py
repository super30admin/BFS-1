"Time Complexity is O(N)"
"Space Complexity is O(H), H being the height of the tree"

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []

        def helper(node, depth):
            if not node:
                return 
            
            if len(result) <= depth:
                result.append([])

            result[depth].append(node.val)

            helper(node.left, depth+1)
            helper(node.right,depth+1)

        helper(root, 0)

        return result

                    