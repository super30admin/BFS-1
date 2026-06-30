# Problem 1
# Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

#BFS
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Time Complexity: O(N) where N is the number of nodes in the tree. 
        #                  Each node is visited and popped from the queue exactly once.
        # Space Complexity: O(N) since the queue will hold up to N/2 nodes at the bottom 
        #                   level of a balanced binary tree. The 'result' array also takes O(N) space.

        # Logic: Handle the edge case of an empty tree.
        if not root:
            return []
        
        # Logic: Use a double-ended queue (deque) to perform a Breadth-First Search (BFS).
        q = collections.deque()
        q.append(root)
        
        # 'size' dictates how many nodes need to be processed for the current level.
        size = 1
        result = []
        level = []

        # Logic: Traverse the tree level by level as long as the queue isn't empty.
        while q:
            # Iterate through all the nodes present in the current level.
            for i in range(size):
                element = q.popleft()
                
                # If children exist, append them to the queue for the next level.
                if element.left:
                    q.append(element.left)
                if element.right:
                    q.append(element.right)
                
                # Store the current node's value in the current level's list.
                level.append(element.val)
            
            # After finishing the current level, add it to our final result array.
            result.append(level)
            
            # Clear the level array to prepare for the next level's values.
            level = []
            
            # Update 'size' to match the number of children added for the next level.
            size = len(q)

        return result