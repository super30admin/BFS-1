# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Handling so many data structures

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {}
        q = []
        indegrees = [0 for _ in range(numCourses)]
        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][1]] += 1
            if prerequisites[i][0] not in graph:
                graph[prerequisites[i][0]] = []
            graph[prerequisites[i][0]].append(prerequisites[i][1])
            
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
            
        while q:
            course = q.pop(0)
            if course in graph:
                children = graph[course]
                for child in children:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        q.append(child)

        for i in range(len(indegrees)):
            if indegrees[i] != 0:
                return False
        return True