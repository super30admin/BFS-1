from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # Time Complexity : O(mn) where m is the number of prerequisites and n is the number of courses
        # Because for every course we are going through the entire prerequisites array
        # Space Complexity : O(n) where n is the number of courses because indegrees array length is number of courses and at any point the max number of elements in the queue is number of courses
        indegrees = [0] * numCourses
        # In prerequisite array, the first index represents the course number and the second index represents the prerequisite course number
        for i in prerequisites:
            indegrees[i[0]] += 1 # The index represents the course number
        queue = deque() # Contains the courses that are completed
        for index, val in enumerate(indegrees):
            if val == 0:
                queue.append(index) # We can complete the courses who don't have any prerequisites
        count = 0
        while len(queue) > 0:
            course = queue.popleft()
            count += 1
            for i in prerequisites:
                if course == i[1]:
                    indegrees[i[0]] -= 1 # decrement the prerequisites for the course
                    if indegrees[i[0]] == 0:
                        queue.append(i[0])
        return count == numCourses