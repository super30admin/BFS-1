"""
TC:O(V+E)
SC:O(V+E)

"""

class Gnode:
    def __init__(self):
        self.inDeg=0
        self.outNodes=[]
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        from collections import defaultdict, deque
        graph = defaultdict(Gnode)
        totalDepth=0
        for relation in prerequisites:
            prevcource=relation[1]
            nextcource=relation[0]
            graph[prevcource].outNodes.append(nextcource)
            graph[nextcource].inDeg+=1
            totalDepth+=1
        nodepCourses = deque()
        for index, node in graph.items():
            if node.inDeg == 0:
                nodepCourses.append(index)
        while nodepCourses:
            course = nodepCourses.pop()
            for nextCourse in graph[course].outNodes:
                graph[nextCourse].inDeg -= 1
                totalDepth-=1
                if graph[nextCourse].inDeg == 0:
                    nodepCourses.append(nextCourse)
        if totalDepth==0:
            return True
        else:
            return False