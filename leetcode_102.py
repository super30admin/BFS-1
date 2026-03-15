#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 102: Binary Tree Level Order Traversal
    Link: https://leetcode.com/problems/binary-tree-level-order-traversal/

    Problem:
    Given the root of a binary tree, return the level order traversal of its
    nodes' values (i.e., from left to right, level by level).

    Approach:
    DFS with a depth parameter. Maintain a running array where index = level.
    When visiting a node at depth ht, append a new list if one doesn't exist yet,
    then append the node's value to array[ht].

    1️⃣ If array has no bucket for depth ht, append a new empty list.
    2️⃣ Append node.val to array[ht].
    3️⃣ Recurse left and right with ht+1.

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(n)
        Output array stores all node values; call stack is O(h).

"""

from collections import defaultdict, deque
from typing import List, Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        self.array = []
        self.htMax = 0

        def height(node, ht):
            self.htMax = max(self.htMax, ht)
            if not node:
                return
            if len(self.array) <= ht:
                self.array.append([])
            self.array[ht].append(node.val)

            height(node.left, ht + 1)
            height(node.right, ht + 1)

        height(root, 0)
        return self.array

    '''
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        hMap = defaultdict(list)
        self.htMax = 0

        def height(node, ht):
            self.htMax = max(self.htMax, ht)
            if not node:
                return
            hMap[ht].append(node.val)
            height(node.left, ht + 1)
            height(node.right, ht + 1)

        height(root, 0)
        ans = []
        for keys in range(0, self.htMax):
            ans.append(hMap[keys])

        return ans
    '''

    '''
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Approach uses size of queue for every level
        if not root:
            return []
        queue = deque()
        queue.append(root)
        ans = []
        while queue:
            level = []
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            ans.append(level)

        return ans
    '''

    '''
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Approach uses a None delimiter for every level
        if not root:
            return []

        queue = deque()
        queue.append(root)
        queue.append(None)

        level = []
        ans = []
        while len(queue) > 1:
            node = queue.popleft()

            if not node:
                ans.append(level)
                level = []
                queue.append(None)
            else:
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        ans.append(level)
        return ans
    '''
