# Passed in leetcode(207)
# time - O(N^2), space - O(N)
# 1. Create a indegrees array using the given prerequisites.
# 2. Start BFS on the nodes not having any prerequisites which are pushed into queue.
# 3. Then process each subject one by one by checking all prerequisites.
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # Prerequisites array: [[4,0],[2,0],[1,4],[1,2],[5,1],[3,2],[5,3]]
        # Indegrees array: [0,2,1,1,1,2]
        # Queue = [0],[2,4],[1][5,3]

        inDegrees = [0 for i in range(numCourses)]  # create a indegrees array
        queue = []
        for i in range(len(prerequisites)):  # Add the indegrees of each node.
            inDegrees[prerequisites[i][0]] += 1
        for i in range(len(inDegrees)):
            if inDegrees[i] == 0:  # append thenodes which has indegrees 0
                queue.append(i)
        while queue:
            course = queue.pop()
            for i in range(len(prerequisites)):
                # if the course matches with queue element, reduce one from indegrees.
                if prerequisites[i][1] == course:
                    inDegrees[prerequisites[i][0]] -= 1
                    # and if indegrees is 0 then append it to queue
                    if inDegrees[prerequisites[i][0]] == 0:
                        queue.append(prerequisites[i][0])

        # check at end if the indegrees array elements are all are 0, return true else return false
        for i in range(len(inDegrees)):
            if inDegrees[i] != 0:
                return False
        return True