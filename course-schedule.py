# Time Complexity: O(V+E) -> vertices + edges of graph
# Space: O(V+E)
# Approach:
# Represent prerequisites as an adjacency list (directed acyclic graph)
# Perform a topological sort on the graph (comments on algorithm in-line)
# If a valid topological sort order exists, return True, else return False

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # Initialize graph
        inDegree = [0 for _ in range(numCourses)]
        adjList = [[] for _ in range(numCourses)]

        # Build Graph Adjacency List
        for (src, dst) in prerequisites:
            adjList[src].append(dst)
            inDegree[dst] += 1

        # Collect sources - nodes with 0 indegree
        sources = collections.deque()
        for i in range(len(inDegree)):
            if inDegree[i] == 0:
                sources.append(i)

        sortedOrder = []
        
        # BFS
        while sources:
            node = sources.popleft()
            sortedOrder.append(node)
            for child in adjList[node]:
                inDegree[child] -= 1
                if inDegree[child] == 0:
                    sources.append(child)
        # Sorted order represents the topological sort order of all the courses
        # If the sorted order doesn'r include all courses, return False
        if len(sortedOrder) != numCourses:
            return False

        return True
