class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        # BFS Approach
        
        result = []
        if not root:
            return root
        
        queue = collections.deque()
        queue.append(root)
        
        while queue:
            
            size = len(queue)
            li = []
            
            for i in range(size):
                root = queue.popleft()
                li.append(root.val)
                
                if root.left:
                    queue.append(root.left)
                if root.right:
                    queue.append(root.right)
                    
            result.append(li)
            
        return result
    
    # Time Complexity: O(n)
    # Space Complexity: O(n)


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        # DFS Approach
        # Passing the level at each call
        def dfs(root, level):
            nonlocal result
            if not root:
                return
            # Checking if the level is equal to the current length of the result array
            # If it is then directy append
            if level == len(result):
                result.append([root.val])
            elif level < len(result): # If not then append at level index in result
                result[level].append(root.val)

            dfs(root.left, level + 1)
            dfs(root.right, level + 1)

        result = []
        dfs(root, 0)
        return result
    
    # Time Complexity: O(n)
    # Space Complexity: O(n)