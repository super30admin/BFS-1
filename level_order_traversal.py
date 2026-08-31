# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
APPROACH:
1. If the tree is empty, return an empty list right away.
2. Use a queue to do BFS, starting with just the root node.
3. Process the tree one level at a time by tracking how many nodes are in the queue at the start of each level.
4. For each node processed, record its value and add its children (if any) to the queue for the next level.
5. Once a level is fully processed, save it as one list inside the final result.

PATTERN:
Tree BFS / Level Order Traversal

TIME COMPLEXITY:
O(n) - every node is visited and processed exactly once

SPACE COMPLEXITY:
O(n) - queue can hold up to one full level of nodes, and result stores all node values

EXAMPLE:
Input:
        3
       / \
      9   20
         /  \
        15   7

Output: [[3], [9, 20], [15, 7]]
Why: level 0 has just 3, level 1 has 9 and 20, level 2 has 15 and 7
"""

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if not root:
            return []  # empty tree has no levels to return

        result = []  # stores final list of levels
        queue = collections.deque()  # queue used for BFS

        queue.append(root)  # start BFS with the root node

        while queue:

            level_size = len(queue)  # number of nodes in current level
            current_level = []  # values for this level

            for i in range(level_size):
                current_node = queue.popleft()  # process next node in this level
                current_level.append(current_node.val)  # record its value

                # add children to queue so they get processed in the next level
                if current_node.left:
                    queue.append(current_node.left)
                if current_node.right:
                    queue.append(current_node.right)
            
            result.append(current_level)  # save this fully processed level
        return result  # all levels collected