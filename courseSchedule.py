# Time Complexity: O(V + E)

# Space Complexity: O(V + E)

# This dependency of number of courses, can be visualized as a directed graph. This is a connected component problem.

# We initially create an indegrees matrix to track which courses have indegrees = 0. We add it to the stack, and process the
# nodes by reducing the indegree of the node by 1, which are dependent on the current course.

from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        if prereq is None or len(prereq) == 0:
            return True
        
        indegrees = [0] * numCourses
        coursesTaken = 0
        map = defaultdict(list)

        for edge in prereq:

            indegrees[edge[0]] += 1

            if edge[1] not in map.keys():
                map[edge[1]] = []
            
            map[edge[1]].append(edge[0])
        
        self.q = deque()

        for i in range(numCourses):
            if indegrees[i] == 0:
                self.q.append(i)
                coursesTaken += 1
        
        while(len(self.q) > 0):
            size = len(self.q)

            for i in range(size):
                curr = self.q.popleft()

                dep = map[curr]
                for v in dep:
                    indegrees[v] -= 1

                    if(indegrees[v] == 0):
                        self.q.append(v)
                        coursesTaken += 1
        
        return coursesTaken == numCourses
        
