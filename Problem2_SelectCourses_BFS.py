'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 207. Course Schedule
# There are a total of numCourses courses you have to take, labeled from 0 
# to numCourses - 1. You are given an array prerequisites where 
# prerequisites[i] = [ai, bi] indicates that you must take course bi first 
# if you want to take course ai.

# For example, the pair [0, 1], indicates that to take course 0 
# you have to first take course 1.
# Return true if you can finish all courses. Otherwise, return false.

#-----------------
# Time Complexity: 
#-----------------
# O(M + N) - Need to iterate over M courses and N requisities once (|V| + |E|)
#------------------
# Space Complexity: 
#------------------
# O(M + N): Need dictionary with M + N space (|V| + |E|). 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
import collections
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        indegrees = [0 for i in range(numCourses)]
        course_map = {i:[] for i in range(numCourses)}
        
        for i in range(len(prerequisites)):
            course = prerequisites[i][0]
            requisite = prerequisites[i][1]
            # if requisite not in course_map:
            #     course_map[requisite] = []
            indegrees[course] += 1
            course_map[requisite].append(course)

        queue = collections.deque()
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                queue.append(i)

        count = 0
        if len(queue) == 0:
            return False
        while len(queue) > 0:
            curr = queue.popleft()
            count += 1
            edges = course_map[curr]
            if edges:
                for edge in edges:
                    indegrees[edge] -= 1
                    if indegrees[edge] == 0:
                        queue.append(edge)
        if count != numCourses:
            return False
        else:
            return True