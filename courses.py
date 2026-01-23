"""
time - o(n)
space - o(n)
here we calculate the in degree of all courses and store them in an array, and create a graph where the prereq is key and courses you can complete after prereq are a list of values
we take the courses that have 0 in degree and add them to a queue to do bfs, once we pop a course from the queue we take all its dependents and reduce the in degree in the list
if any indegree is 0, it means it has satisfied all prereqs and can go onto the list. finally all courses popped from the list are tallied and if equal to numcourses we return true
"""
from collections import deque
from typing import List
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:   
        
        in_degree = [0]*numCourses
        dep_graph = {}
        for i in range(len(prerequisites)):
            a,b = prerequisites[i]
            in_degree[a]+=1
            if b not in dep_graph:
                dep_graph[b] = []
            dep_graph[b].append(a)
        q = deque()
        for index, val in enumerate(in_degree):
            if val==0:
                q.append(index)
        done_courses = 0
        while q:
            node = q.popleft()
            done_courses+=1
            if node in dep_graph:
                for course in dep_graph[node]:
                    in_degree[course]-=1
                    if in_degree[course]==0:
                        q.append(course)
            
        return done_courses==numCourses


        
        