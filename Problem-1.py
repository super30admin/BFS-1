"""
Approach: use BFS and note the node values at each level, left to right.

TC: O(n)
SC: O(n)
"""

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return root
        queue_nodes = [[root]]
        result = []
        while queue_nodes[0]:
            nodes = queue_nodes.pop(0)
            next_level_nodes = []
            curr_level = []
            for node in nodes:
                curr_level.append(node.val)
                if node.left:
                    next_level_nodes.append(node.left)
                if node.right:
                    next_level_nodes.append(node.right)
            queue_nodes.append(next_level_nodes)
            result.append(curr_level)
        return result
