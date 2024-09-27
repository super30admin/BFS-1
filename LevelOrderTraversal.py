// 1. Time complexity: O(N)
// 2. Space Complexity: O(N)
// 3. Run on Leetcode: Yes
// 4. Face any problem : No

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = []
        if not root:
            return levels
        
        def helper(node, level):
            if len(levels) == level:
                levels.append([])

                
            levels[level].append(node.val)

            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)
            
        helper(root, 0)
        return levels