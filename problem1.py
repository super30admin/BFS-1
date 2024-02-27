# https://leetcode.com/problems/binary-tree-level-order-traversal/

# Time Complexity : O(N) where N is number of nodes in the binary tree
#  Space Complexity : O(N)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : None


# Your code here along with comments explaining your approach.
# Approach : This is a BFS solution where I traverse the whole tree one level at a time,
# and add the level list to the result


from queue import Queue
from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = Queue()
        q.put(root)
        result = []
        while q.qsize() > 0:
            current_row_size = q.qsize()
            level = []
            for i in range(current_row_size):
                cur_node = q.get()
                level.append(cur_node.val)
                if cur_node.left is not None:
                    q.put(cur_node.left)
                if cur_node.right is not None:
                    q.put(cur_node.right)
            result.append(level)
        return result
