from typing import List
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites == None or len(prerequisites) == 0:
            return True
        indegrees = [0] * numCourses
        preMap = {}
        for prereq in prerequisites:
            ind = prereq[0]
            out = prereq[1]
            indegrees[ind] += 1
            if out not in preMap.keys():
                preMap[out] = list()
            preMap[out].append(ind)     
        q = deque()
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
        if len(q) == 0:
            return False
        count = 0
        while len(q) != 0:
            curr = q.popleft()
            count += 1
            if curr in preMap.keys():
                edges = preMap[curr]
                if edges != None:
                    for edge in edges:
                        indegrees[edge] -= 1
                        if indegrees[edge] == 0:
                            q.append(edge)
        if count != numCourses:
            return False
        return True

# Time Complexity = O(V+E)
# Space Complexity = O(V+E)


# DFS Solution
# class Solution:
#     def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
#         if prerequisites == None or len(prerequisites) == 0:
#             return True
#         self.visited = [False] * numCourses
#         self.path = [False] * numCourses
#         self.preMap = {}
#         for prereq in prerequisites:
#             if prereq[1] not in self.preMap.keys():
#                 self.preMap[prereq[1]] = list()
#             self.preMap[prereq[1]].append(prereq[0]) 
#         for i in range(numCourses):
#             if not self.visited[i] and self.hasCycle(i):
#                 return False
#         return True
     
#     def hasCycle(self, i: int) -> bool:
#         if self.path[i]:
#             return True
#         if self.visited[i]:
#             return False
#         self.visited[i] = True
#         self.path[i] = True
#         if i in self.preMap.keys():
#             children = self.preMap[i]
#             if len(children) > 0:
#                 for child in children:
#                     if self.hasCycle(child):
#                         return True
                    
#         self.path[i] = False
#         return False

# Time Complexity = O(V+E)
# Space Complexity = O(V+E)