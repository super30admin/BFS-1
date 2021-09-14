#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Sep 14 13:57:38 2021

@author: ameeshas11
"""

#Time Complexity : O(V+E)
#Space Complexity : O(V) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indeg = [0]*numCourses
        hmap = {}
        if len(prerequisites) == 0:
            return True
        for i in prerequisites:
            indeg[i[0]] += 1
            if i[1] in hmap.keys():
                hmap[i[1]].append(i[0])
            else:
                hmap[i[1]] = [i[0]]
        
        q = deque()
        c = 0
        for i in range(len(indeg)):
            if indeg[i] == 0:
                q.append(i)
                c +=1
        if len(q)==0:
            return False
        while q:
            curr = q.popleft()
            if curr in hmap.keys():
                li = hmap[curr]
                if len(li) > 0:
                    for i in range(len(li)):
                        indeg[li[i]] -= 1
                        if indeg[li[i]] == 0:
                            q.append(li[i])
                            c += 1
                        
        if c == numCourses:
            return True
        else:
            return False