# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

# approach
# topological sort using BFS and adjacency list

from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # base
        if not prerequisites:
            return True
        indegrees = [0 for _ in range(numCourses)]
        # adj list
        # {ind: [dep]}
        dependents = defaultdict(list)
        for pre in prerequisites:
            indegrees[pre[0]] += 1
            dependents[pre[1]].append(pre[0])
        q = deque([])
        # start processing from independent courses having no prereq
        for nc in range(numCourses):
            if indegrees[nc] == 0:
                q.append(nc)
        # if no element added to queue means not possible to take all courses
        if not q:
            return False
        # process queue
        # reduce indegree for dependents by 1 and if it becomes 0 add to queue
        while q:
            course = q.popleft()
            for dep in dependents[course]:
                indegrees[dep] -= 1
                if indegrees[dep] == 0:
                    q.append(dep)
        # check if all indegrees are zero
        # if yes then there is a proper way to take all courses
        # if no there is a cycle in the graph and it is impossible to take all courses
        for nc in range(numCourses):
            if indegrees[nc] > 0:
                return False
        return True

# DFS

from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # base
        if not prerequisites:
            return True
        # adj list rep
        dependents = defaultdict(list)
        for pre in prerequisites:
            # indegrees[pre[0]] += 1
            dependents[pre[1]].append(pre[0])
            
        visited = [False for _ in range(numCourses)]
        path = [False for _ in range(numCourses)]
        
        def cycleExists(c, dependents, visited, path):
            if visited[c]:
                return False
            if path[c]:
                return True
            path[c] = True
            for child in dependents[c]:
                if cycleExists(child, dependents, visited, path):
                    return True
            path[c] = False
            visited[c] = True
            return False
        
        for c in range(numCourses):
            if cycleExists(c, dependents, visited, path):
                return False
        return True