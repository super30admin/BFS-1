#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 17 10:00:49 2019

@author: tanvirkaur
"""

import collections
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        BFS approach
        time complexity = O(V+E)
        Space complexity = O(n)
        """
        from collections import deque
        q = deque()
        q.append(root)
        if not root:
            return None
        res =[]
        tmp = []
        while q:
            tmp = []
            count = len(q)
            for i in range(count): #printing the last element of each level
                node = q.popleft()
                tmp.append(node.val)
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
            res.append(tmp[-1])
        return res