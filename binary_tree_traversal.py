class Solution:
    '''
    Time Complexity: O(n)
    Space Complexity: O(width)
    '''
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        res, curr = [], [root]

        while curr:
            sub_level, vals = [], []

            for node in curr:
                vals.append(node.val)
                if node.left:
                    sub_level.append(node.left)
                if node.right:
                    sub_level.append(node.right)

            curr = sub_level
            res.append(vals)
        return res