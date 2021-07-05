# Time Complexity : O(E + V)
# Space Complexity : O(E + V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
1. Built a graph with inDegrees and outDegrees. Measure the depth of graph
2. search for node with zero inDegree and put in the queue
3. start removing edge from the item in queue
4. when all edges are removed and then we compare it with total Depth and return result
"""

class GNode(object):
    def __init__(self):
        self.inDegrees = 0
        self.outNodes = []

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        graph = defaultdict(GNode)
        totalDeps = 0
        
        for relation in prerequisites:
            nextCourse, prevCourse = relation[0], relation[1]
            graph[prevCourse].outNodes.append(nextCourse)
            graph[nextCourse].inDegrees += 1
            totalDeps += 1
            
        nodepCourses = deque()
        
        for index, node in graph.items():
            if node.inDegrees == 0:
                nodepCourses.append(index)

        removedEdges = 0

        while nodepCourses:
            course = nodepCourses.pop()
            for nextCourse in graph[course].outNodes:
                graph[nextCourse].inDegrees -= 1
                removedEdges += 1
                if graph[nextCourse].inDegrees == 0:
                    nodepCourses.append(nextCourse)

        if removedEdges == totalDeps:
            return True
        else:
            return False