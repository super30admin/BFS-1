'''
102 Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Solution:
1. Iterative: Since the tree structure allows us to access nodes starting from the root and moving downward, this process naturally follows a First-In-First-Out (FIFO) order. So we can use queue data structure to perform level order traversal.
First, we insert the root into the queue and iterate over the queue until the queue is empty. In every iteration, we pop from the top of the queue and print the value at the top of the queue. Then, add its left and right nodes to the end of the queue.
Time: O(N), Space: O(N) (more specifically, it is O(D), D = diameter of tree)
(Note: If there are N nodes in a tree, the max no. of leaves possible is N/2)
https://www.youtube.com/watch?v=AIdppB34TEQ


2. Recursive:
Time: O(N), Space: O(H), H = height of tree
'''

from binary_tree import *

def level_order_bfs(root):
    ''' Time: O(N), Space: O(N) '''
    if not root:
        return []
    q = deque()
    q.append(root)
    result = []
    while q:
        sz = len(q)
        level_nodes = []
        for _ in range(sz):
            curr = q.popleft()
            level_nodes.append(curr.val)
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
        result.append(level_nodes)
    return result

def level_order_dfs(root):
    ''' Time: O(N), Space: O(H) '''
    def dfs(root, level):
        if not root:
            return
        N = len(result)
        if level >= N:
            result.append([])
        result[level].append(root.val)
        dfs(root.left, level+1)
        dfs(root.right, level+1)
        return
    if not root:
        return []
    result = []
    dfs(root, 0)
    return result

def run_level_order():
    tests = [([3,9,20,None,None,15,7], [[3],[9,20],[15,7]]),
             ([1],[[1]]),([],[[None]])
    ]
    for test in tests:
        root, ans = test[0], test[1]
        tree=build_tree_level_order(root)
        tree.display()
        print(f"root = {root}")
        for method in ['bfs','dfs']:
            if method == 'bfs':
                result = level_order_bfs(tree)
            elif method == 'dfs':
                result = level_order_dfs(tree)
            print(f"Method {method}: Level order traversal = {result}")
            passed = (ans == result)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")

    print(f"\nDONE")


run_level_order()