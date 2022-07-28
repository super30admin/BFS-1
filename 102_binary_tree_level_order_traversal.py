'''

## Problem 102: Binary tree level order traversal.

## Author: Neha Doiphode
## Date:   07-25-2022

## Description:
    Given the root of a binary tree, return the level order traversal of its nodes' values.
    (i.e., from left to right, level by level).

## Examples:
    Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[9,20],[15,7]]

    Example 2:
        Input: root = [1]
        Output: [[1]]

    Example 3:
        Input: root = []
        Output: []

## Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000

## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''
from queue import Queue
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def to_binary_tree(items):
    if not items:
        return None

    # iter(object, sentinel [optional])
    # sentinel = special character used to represent end of the sequence.
    it = iter(items)
    root = TreeNode(next(it))
    q = [root]
    for node in q:
        val = next(it, None)
        if val is not None:
            node.left = TreeNode(val)
            q.append(node.left)
        val = next(it, None)
        if val is not None:
            node.right = TreeNode(val)
            q.append(node.right)
    return root

def get_input():
    print("Enter nodes of tree with spaces at height h, from left to right.")
    print("Input null if no left or right child to a node at height h.")
    inp_list = input()
    inp_list = inp_list.split()
    l = []
    for value in inp_list:
        if value != "null":
            l.append(int(value))
        else:
            l.append(None)

    root = to_binary_tree(l)
    if root.val == None:
        l = []
        root = None
    return l, root

class Solution:
    # Used in the DFS based approach
    result = []
    def levelOrder_bfs(self, root: Optional[TreeNode]) -> List[List[int]]:
        '''
        Approach: Breadth First Search
        Time complexity : O(n), where n is number of nodes in the tree.
                                We traverse each node once.
        Space complexity: O(n), At a time auxiliary queue will have number of nodes at level 'l'.
                                Max number of nodes will be present at the last level if all each node on the previous level
                                has left and right child both.
                                For example,
                                if a tree has 4 levels, and each node has left and right child both,
                                level 0 = 1 node(root)(2 ^ 0)
                                level 1 = 2 (2 ^ 1)
                                level 3 = 4 (2 ^ 2)
                                level 4 = 8 (2 ^ 3)

                                Total number of nodes in the tree = 1 + 2 + 4 + 8 = 15
                                Nodes at the last level           = 8 ~= n/2

                                So, at a time, at the max n/2 nodes will be present in the queue.
                                Asymptotically, we can say that space complexity is O(n/2) ~= O(n).
        '''
        if root == None:
            return []

        answer = []
        q = Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            temp = []
            while size:
                root = q.get()
                temp.append(root.val)

                if root.left:
                    q.put(root.left)

                if root.right:
                    q.put(root.right)

                size -= 1
            if len(temp) != 0:
                answer.append(temp)
        return answer

    def dfs(self, root: TreeNode, level: int) -> None:
        if root == None:
            return

        if level == len(self.result):
            temp = []
            self.result.append(temp)

        self.result[level].append(root.val)
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)

    def levelOrder_dfs(self, root: Optional[TreeNode]) -> List[List[int]]:
        '''
        Approach: Depth First Search
                  Approach makes use of pre-order tree traversal.
                  As we reach a certain level/height h of the tree, we just initiate a new list.
                  During traversal, when we reach a particular node at level l,
                  we just append value of the node to the list reated for that level.

                  We can choose in-order traversal as well,
                  but the approach needs us to count levels present in the tree first,
                  to create number of blank lists. So, add the overhead of counting levels first

        Time complexity : O(n), where n is number of nodes in the tree.
                                We traverse each node once.
        Space complexity: O(h), where h is the height of the tree.
        '''
        if root == None:
            return []

        level = 0
        self.result = []
        self.dfs(root, level)
        return self.result

# Driver code
solution = Solution()
l, root = get_input()
print(f"Input Tree: {l}", end = "")
print()
print(f"Approach 1: With BFS: Level order traversal: {solution.levelOrder_bfs(root)}")
print(f"Approach 2: With DFS: Level order traversal: {solution.levelOrder_dfs(root)}")
