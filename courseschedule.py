# Time Complexity: O(E + V)
# Space Complexity: O(E + V)

from collections import deque
from collections import defaultdict
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        countCourses = 0
        result = []
        if len(prerequisites) == 0:
            return True
        adjList, indegreeList = self.buildGraphandIndegree(prerequisites, numCourses)
        # iterate the indegree list and add the independent node (node with indegree 0) for processing
        sources = deque()
        for node in range(len(indegreeList)):
            if indegreeList[node] == 0:
                sources.append(node)
        # iterate the queue (BFS manner) pop the added independent node then traverse the dependent nodes of itself.
        # When you pick a dependent node decrease its indegree and if it reaches 0 add it to the queue
        while sources:
            poppedcourse = sources.popleft()
            countCourses += 1  # course is already taken so we count it
            for dependentcourse in adjList[poppedcourse]:
                indegreeList[dependentcourse] -=1
                if indegreeList[dependentcourse] == 0:
                    sources.append(dependentcourse)
        return countCourses == numCourses


    def buildGraphandIndegree(self, prerequisites, numCourses):
        adjList = {i: [] for i in range(numCourses)}
        indegreeList = {i: 0 for i in range(numCourses)}
        for parent, child in prerequisites:
            adjList[parent].append(child)
            indegreeList[child] += 1
        return adjList, indegreeList
