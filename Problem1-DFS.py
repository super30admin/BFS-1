class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Time Complexity: O(N), where N is the number of nodes in the tree. 
        #                  Each node is visited exactly once during the traversal.
        # Space Complexity: O(N) overall. The recursion stack uses O(H) space, where H is the 
        #                   tree height (worst case O(N) for a skewed tree, O(log N) for balanced). 
        #                   The 'result' array also takes O(N) space to store the node values.
        
        result = []
        
        # Logic: Use a recursive helper function to perform DFS, keeping track of the current depth 'level'.
        def dfs(root, level):
            nonlocal result
            
            # Base case: if the current node is null, stop recursion.
            if not root:
                return
            
            # Logic: If the length of 'result' equals the current 'level', it means we are 
            # visiting this depth for the first time. We append a new list with the node's value.
            if len(result) == level:
                result.append([root.val])
            # Logic: If a list for this depth already exists, simply append the node's value to it.
            else:
                result[level].append(root.val)
            
            # Recursively traverse the left and right subtrees, incrementing the level by 1.
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
            
        # Initialize the DFS traversal starting at the root node (level 0).
        dfs(root, 0)
        
        return result