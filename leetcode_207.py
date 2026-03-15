#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 207: Course Schedule
    Link: https://leetcode.com/problems/course-schedule/

    Problem:
    There are numCourses courses labeled 0 to numCourses-1. You are given an array
    prerequisites where prerequisites[i] = [a, b] means you must take course b before a.
    Return true if you can finish all courses, false if a cycle exists.

    Approach:
    Topological sort (Kahn's algorithm / BFS). Build an adjacency list and indegree
    array from prerequisites. Seed the queue with all zero-indegree nodes, then
    repeatedly remove a node and decrement the indegree of its neighbors.
    If all indegrees reach 0, no cycle exists.

    1️⃣ Build adjMap and indegreeCount from prerequisites.
    2️⃣ Seed queue with all nodes whose indegree == 0.
    3️⃣ Early exit: if no zero-indegree nodes → cycle guaranteed → False.
    4️⃣ Early exit: if all nodes have indegree 0 → no prerequisites → True.
    5️⃣ BFS: for each dequeued course, decrement neighbors' indegrees; enqueue if 0.
    6️⃣ After BFS, if any indegree remains > 0 → cycle exists → False.

    // Time Complexity : O(V + E)
        V = numCourses, E = number of prerequisites.
    // Space Complexity : O(V + E)
        Adjacency list and indegree array.

"""

from collections import defaultdict, deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegreeCount = [0] * numCourses
        adjMap = defaultdict(list)

        for preRequisite in prerequisites:
            adjMap[preRequisite[1]].append(preRequisite[0])
            indegreeCount[preRequisite[0]] += 1

        queue = deque()
        for i in range(len(indegreeCount)):
            if indegreeCount[i] == 0:
                queue.append(i)

        # Further optimizations:
        if len(queue) == 0:
            return False

        if len(queue) == numCourses:
            return True

        while queue:
            currCourse = queue.popleft()
            for childCourse in adjMap[currCourse]:
                indegreeCount[childCourse] -= 1
                if indegreeCount[childCourse] == 0:
                    queue.append(childCourse)

        for i in range(len(indegreeCount)):
            if indegreeCount[i] != 0:
                return False

        return True
