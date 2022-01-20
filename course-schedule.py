'''
TC: O(E) - edges in graph
SC: O(V) - nodes in graph
'''
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        
        graph = {index: list() for index in range(numCourses)}
        indeg = {index: 0 for index in range(numCourses)}
        curr_courses = 0
        
        for req in prerequisites:
            graph[req[0]].append(req[1])
            indeg[req[1]] += 1
        
        q = []
        for index in indeg:
            if indeg[index] == 0:
                q.append(index)
        
        if not q:
            return False
        
        while q:
            top = q.pop(0)
            curr_courses += 1
            for child in graph[top]:
                indeg[child] -= 1
                if indeg[child] == 0:
                    q.append(child)
        
        return curr_courses == numCourses
        