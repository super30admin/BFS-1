'''
Solution:
1.  Keep track of indegrees in an Array along with children of each node (course) in a HashMap. Push all those nodes to
    the Queue whose indegree is zero (no prerequisite exists) and if no such node exists, then courses can't be finished.
2.  For each node (course) in Queue, traverse all its children (BFS) and reduce their indegree by one because if the
    prerequisite course is completed, then its children nodes are cleared off its dependency.
3.  After all the nodes, if indegree of any course is still greater than zero, it means courses can't be finished;
    otherwise courses can be finished.

Time Complexity: O(V + E)   Space Complexity:   O(V + E)

--- Passed all testcases on Leetcode successfully
'''


from collections import deque


class CourseSchedule(object):

    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if (prerequisites == None):     return True

        indegrees = [0 for i in range(numCourses)]              # O(V) Space for indegrees array

        children = {i: [] for i in range(numCourses)}           # O(E) Space for children mapping

        #   Update indegrees Array and children HashMap in parallel
        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][0]] += 1
            children[prerequisites[i][1]].append(prerequisites[i][0])

        #   initialize a queue
        queue = deque()

        #   add all those courses having no dependency to the queue
        for i in range(len(indegrees)):
            if (indegrees[i] == 0):
                queue.append(i)

        #   iterate over the queue while updating indegrees and add a course to the queue whenever it has no prereqs
        while (len(queue) > 0):

            prereqCourse = queue.popleft()

            for child in children[prereqCourse]:
                indegrees[child] -= 1
                if (indegrees[child] == 0):
                    queue.append(child)

        #   After the Queue being empty, if any indegree is greater than zero, just the courses can't be finished.
        for i in range(len(indegrees)):
            if (indegrees[i] != 0):     return False

        return True