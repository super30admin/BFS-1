# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We use a DFS preorder traversal of the tree. We maintain a list of lists as the final result.
# We maintain the height of the node in the DFS recursion and then dynamically add elements to the 
# correct index of the final list, corresponding to the accumulated height value.
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res

        def helper(root, ht):
            if not root:
                return
            if len(res) == ht:
                res.append([])
            res[ht].append(root.val)
            helper(root.left, ht+1)
            helper(root.right, ht+1)

        helper(root, 0)
        return res
