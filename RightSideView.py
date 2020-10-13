// 1. Time complexity: O(N)
// 2. Space Complexity: O(D), diameter of tree
// 3. Run on Leetcode: Yes
// 4. Face any problem : No

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        next_level = deque([root,])
        rightside = []
        
        while next_level:
            curr_level = next_level
            next_level = deque()

            while curr_level:
                node = curr_level.popleft()
                
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)

            rightside.append(node.val)
        
        return rightside