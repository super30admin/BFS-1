# Time Complexity  : O(N) 
#   → Each node in the binary tree is visited exactly once.
#
# Space Complexity : O(N)
#   → In the worst case (a full binary tree), the queue stores 
#     roughly N/2 nodes at the last level.
#
# Did this code successfully run on Leetcode? : Yes
#
# Any problems you faced while coding this? :
#   Initially, none. The logic is straightforward — just ensure 
#   you handle the empty tree case and use a proper BFS pattern.
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Edge case: if the tree is empty, return an empty list
        if not root:
            return []

        result = []   # This will store the final list of levels
        q = [root]    # Initialize queue with the root node (for BFS)

        # 🔁 Continue until there are no nodes left in the queue
        while q:
            level = []  # List to store the values of the current level

            # Process all nodes currently in the queue (current level)
            for i in range(len(q)):
                node = q.pop(0)        # Pop the first node in the queue
                level.append(node.val) # Add its value to the level list

                # If left child exists, enqueue it
                if node.left:
                    q.append(node.left)
                # If right child exists, enqueue it
                if node.right:
                    q.append(node.right)

            # After processing one level, add it to the result
            result.append(level)

        # Return the list of levels, each containing node values
        return result