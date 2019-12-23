#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Dec 23 10:02:30 2019

@author: tanvirkaur
"""

#time complexity = O(n)
# space complexity = O(n)
from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0]*numCourses
        graph = defaultdict(list)
        q = []
        for i in range(len(prerequisites)):
            if prerequisites[i][0] not in graph:
                graph[prerequisites[i][0]] = [prerequisites[i][1]]
            else:
                graph[prerequisites[i][0]].append(prerequisites[i][1])
        print(graph)
        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][1]] += 1
        print(indegrees)
        for i in range(numCourses):
            if indegrees[i] == 0:
                q.append(i)
        while q:
            node = q.pop(0)
            vertices = graph[node]
            for v in vertices:
                indegrees[v] -= 1
                if indegrees[v] == 0:
                    q.append(v)
        for i in range(numCourses):
            if indegrees[i] >0:
                return False
        return True