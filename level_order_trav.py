#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 14:00:36 2021

@author: ameeshas11
"""

#Time Complexity : O(V)
#Space Complexity : O(V) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        Li = []
        if root == None:
            return Li
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            temp = []
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left!=None:
                    q.append(curr.left)
                if curr.right!=None:
                    q.append(curr.right)
            Li.append(temp)
        
        
        return Li
        