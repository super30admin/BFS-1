# Time Complexity : O(e + v) where e is edge and v is vertices
# Space Complexity :O(e + v) where e is edge and v is vertices
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no





from collections import defaultdict, deque
class Node(object):
    def __init__(self):
        self.inDegrees = 0
        self.outNodes = []


class Solution:

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        graph = defaultdict(Node)

        dependency = 0

        for prerequisite in prerequisites:
            nextCourse, prevCourse = prerequisite[0], prerequisite[1]

            graph[prevCourse].outNodes.append(nextCourse)

            graph[nextCourse].inDegrees += 1

            dependency += 1

        noDependency = deque()

        for index, node in graph.items():
            if node.inDegrees == 0:
                noDependency.append(index)

        removedEdges = 0

        while noDependency:

            course = noDependency.pop()

            for nextCourse in graph[course].outNodes:
                graph[nextCourse].inDegrees -= 1
                removedEdges += 1

                if graph[nextCourse].inDegrees == 0:
                    noDependency.append(nextCourse)

        if removedEdges == dependency:
            return True
        else:
            return False



