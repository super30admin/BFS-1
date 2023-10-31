# TC: O(V+E)
# SC: O(V+E)


# intuition: BFS
# create an adjacency map i.e. who are the neighbors of a given node (outgoing) so that you can tarverse through these nodes. (Independent nodes as Keys & dependent nodes are their values)
# create indegrees array. Note count of incoming arrows for a given node with idx of the array = node value
# maintain a queue of independent nodes for BFS
# Put ALL independent nodes in the queue.
# Iterate through the queue, for each independent node, find its neighbors. Decrement their counts in inDegrees array that means we have traverse through those node. If any value becomes 0 i.e. node becomes independent, add that node to queue. Keep doing this until queue is not empty.

# Once q is empty, loop through indegrees array. If all values are not 0, that means some course was not taken return false. Else return True
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """

        # size = len(prerequisites) + 1
        # print(size)
        inDeg = [0 for i in range(0, numCourses)]
        q = []
        adjMap = {}

        for i in prerequisites:
            # i is a vector or the edge in this case

            inA = i[0]
            outA = i[1]
            inDeg[inA] += 1
            if outA not in adjMap:
                adjMap[outA] = []
            adjMap[outA].append(inA)

        print(adjMap)

        for i in range(numCourses):
            if inDeg[i] == 0:
                q.append(i)

        while len(q) > 0:
            independentCourse = q.pop(0)
            print("pop", independentCourse)
            print("queue", q)
            # print(adjMap[independentCourse])
            if independentCourse in adjMap:
                dependentCourses = adjMap[independentCourse]
                for course in dependentCourses:
                    inDeg[course] -= 1
                    if inDeg[course] == 0:
                        q.append(course)

        for i in range(len(inDeg)):
            if inDeg[i] != 0:
                return False

        return True
