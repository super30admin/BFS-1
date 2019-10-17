#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 15 14:30:04 2019

@author: tanvirkaur
"""

import collections
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        BFS level order traversal
        time complexity = O(n), n = v+e
        Space Complexity = O(n)
        """
        from collections import deque
        if not root:
            return None
        tmp = []
        res = []
        q = deque()
        q.append(root)
        while q :
            tmp = []
            for i in range(len(q)):
                node = q.popleft()
                tmp.append(node.val)
                if node.left!= None:
                    q.append(node.left)
                if node.right!= None:
                    q.append(node.right)
            res.append(tmp)
        return res