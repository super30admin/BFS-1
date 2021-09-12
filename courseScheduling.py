from queue import Queue


class Solution:
    """
    TC: O(V + E)
    SC: O(3V + E)
    V -> indegree list, V -> Queue, V + E -> adjacency list
    where V -> no. of courses and E -> prerequisites
    """

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        # if there are no prereqs then return True
        if len(prerequisites) == 0:
            return True

        indegree = [0 for i in range(numCourses)]
        adjList = {}
        queue = Queue()

        # hashmap for storing the prereqs(adjaceny list) and indegree list

        for x in prerequisites:
            fRom = x[0]
            to = x[1]
            print(to)
            indegree[to] += 1

            if not fRom in adjList.keys():
                adjList[fRom] = []

            adjList[fRom].append(to)

        # queue to store independent and adjacent nodes
        for i in range(numCourses):

            if indegree[i] == 0:
                queue.put(i)

        # perform BFS on the graph
        while not queue.empty():
            front = queue.get()

            if front in adjList.keys():
                for x in adjList[front]:
                    indegree[x] -= 1

                    if indegree[x] == 0:
                        queue.put(x)

        for x in indegree:
            if x != 0:
                return False

        return True
