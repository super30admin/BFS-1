"""
I use dfs property to check for cycles and see if we are ever to find one, if found return false immediaely. 
If not, check for the neighbours whether they have any cycles or not. If a node comes out of this loop, no 
cycles exist and return True. 
TC is o(V+E) and SC is O(V+E) as we store both - the nodes and their relationships"""

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        #graph building
        graph = defaultdict(list)
        for course, pre in prerequisites:
            graph[pre].append(course)

        visit = [0] * numCourses

        def dfs(course):
            if visit[course] == 1:
                return False #cycle detected
            if visit[course] == 2:
                return True #no cycle

            visit[course] = 1 #mark current course as current visiting/exploring
            for neigh in graph[course]:
                if not dfs(neigh): 
                    return False #cycle detected

            visit[course] = 2 #mark it as visited/ explored
            return True

        for c in range(numCourses):
            if not dfs(c):
                return False
        return True


