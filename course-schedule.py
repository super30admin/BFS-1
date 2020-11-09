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

        # Build Graph
        for (src, dst) in prerequisites:
            adjList[src].append(dst)
            inDegree[dst] += 1

        # Collect sources
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

        if len(sortedOrder) != numCourses:
            return False

        return True
