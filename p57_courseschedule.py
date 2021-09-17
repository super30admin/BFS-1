"""
https://leetcode.com/problems/course-schedule/
We will make use of three different data structures like an indegree array of datatype list, adjacency matrix, and using deque for
search.
TC: O(n)
Sc:O(n)

"""

import collections
class Solution:
    def canFinish(self, numCourses, prerequisites):
        indegreesArray=[]
        adjacencyMatrix = dict()

        for edge in prerequisites:
            indegreesArray[edge[0]]+=1 ##node dependent on something
            if not edge[1] in adjacencyMatrix:
                # adjacencyMatrix[edge[1]]=[edge[0]]
                adjacencyMatrix[edge[1]].append([edge[0]]) ####adding dependepnt values on independent keys

        deQ=collections.deque()
        count=0
        ###now adding independent nodes
        for i in range(len(indegreesArray)):
            if indegreesArray[i]==0: ##if the node is not dependent on any node
                deQ.appendleft(i)
                count+=1
        ###BFS
        while not len(deQ) == 0:
            currentCourse=deQ.popleft()
            ###take all the courses which were dependent on this course
            children=adjacencyMatrix.get(currentCourse)
            if children!=None:
                for child in children:
                    indegreesArray[child]-=1
                    if indegreesArray[child]==0:
                        deQ.appendleft(child)
                        count+=1


        return count==numCourses


numCourses = 2
prerequisites = [[1, 0]]


