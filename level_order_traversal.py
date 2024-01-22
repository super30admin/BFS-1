# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
""" 
// Time Complexity : O(N)
The Space Complexity for BFS solution would be O(N), but not because all the elements are in the queue, as all elements in queue are
not present at the same time, hence, the SC would be max nodes in a level, which in the case of a complete binary tree is same
as (n+1)/2
for n = 7, there are 4 leaf nodes
8 + 4 + 2 + 1= 15
for n = 15, there are 8 leaf nodes
// Space Complexity : O(N+1/2) ~ O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Used Queue to perform Level order traversal, insert the root into the Queue, then iterate while q,
get the length of q into size varibale, iterate till size,
perform pop, and insert left and right, and append popped_val into result,
at the end of every exit of size's while loop, insert the result into final_result and make result as empty list.
"""
from typing import Optional, List
from collections import deque
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = deque()
        queue.append(root)
        final_result = []
        result = []
        if not root:
            return []
        queue.append(root)
        while queue:
            size = len(queue)
            while size:
                pop_node = queue.popleft()
                if pop_node:
                    result.append(pop_node.val)
                    if pop_node.left:
                        queue.append(pop_node.left)
                    if pop_node.right:
                        queue.append(pop_node.right)
                size -= 1
            final_result.append(result)
            result = []
        return final_result

    """
    For DFS, as we are not traversing in a level wise, we need to take care of how we store the elements in the result
    One way is to use a dictionary and append values to the list of dictionary based on the height(level), however, the dictionary is
    unsorted, so we need to keep track of max_height and iterate from 0 to max_height and store it in a result array in that order and return result
    Another way to do it is, instead of dictionary using the list only, but appending a new list for each time we enter a new level
    Done using the condition if height is same as len(level_order) then append a new list(for the new level).
    """
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        level_order = []
        def dfs(root, height):
            if not root:
                return
            if height == len(level_order):
                level_order.append([])
            
            level_order[height].append(root.val)
            dfs(root.left, height+1)
            dfs(root.right, height+1)
        dfs(root, 0)
        return level_order