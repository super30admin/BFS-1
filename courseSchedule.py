"""
BFS Approach --
1. For easier visualization, map the input into a graphs for simplicity to
understand which course has which pre req
2. Since it is a graph (directed graph) in this case, we perform BFS traversal
to understand the course and their pre req

# TC - O(V+E)
# SC - O(V+E)
"""


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0: return True

        indegrees = [0 for i in range(numCourses)]

        adjList = defaultdict(list)

        # to track all the completed courses
        coursesCompleted = 0

        for edge in prerequisites:
            _in = edge[0]
            _out = edge[1]

            indegrees[_in] += 1
            adjList[_out].append(_in)
        # print(indegrees)
        # print(adjList)

        q = deque()
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                coursesCompleted += 1
                q.append(i)
        # print(q)

        while q:
            curr = q.popleft()
            edges = adjList[curr]
            if edges is not None:
                for edge in edges:
                    # subtract the count in indegrees by 1
                    indegrees[edge] -= 1
                    if indegrees[edge] == 0:
                        coursesCompleted += 1
                        q.append(edge)

        return coursesCompleted == numCourses
