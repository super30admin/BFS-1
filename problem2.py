'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation : Create adj list and iterate through it, keep track of indegree list and once we see a node with 0 indegree
we choose that put that in a queue and find all corresponding courses for that pre req ie remove all incoming edges of
the course. Hence degree reduces and you have a total variable to keep track of number of courses seen. Result is the matrix
keeping track of level order.
'''


class Solution:
    def canFinish(self, numCourses: int, prereq: List[List[int]]) -> bool:
        # create adjency list
        graph = {}
        for i in range(0, numCourses):
            graph[i] = []

        indegree = [0 for x in range(0, numCourses)]
        for t in prereq:
            course = t[0]
            pre = t[1]
            graph[pre].append(course)
            indegree[course] += 1

        print(graph)
        # topological sort

        queue = []
        for i in range(0, numCourses):
            if indegree[i] == 0:
                queue.append(i)

        print(indegree)
        count = 0
        while len(queue) != 0:
            # current we can take right now
            current = queue[0]

            queue = queue[1:]

            correspondingCourse = graph[current]

            for course in correspondingCourse:
                indegree[course] -= 1

                if indegree[course] == 0:
                    queue.append(course)

            count += 1

        # count keeps tracks of number of course sencountered
        if count == numCourses:
            return True
        else:
            return False