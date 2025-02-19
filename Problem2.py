# Problem 2 : Course Schedule
# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
from collections import deque, defaultdict

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # initialize the graph dictionary for the storing the info about the course and prerequisite
        graph = defaultdict(list)

        # Initialize indegree array which store count of prerequisit for course
        indegree = [0] * numCourses

        # building the graph and setting the indegree array
        for course, preq in prerequisites:
            graph[preq].append(course)
            indegree[course] += 1
        
        # start with the course with indegree value as 0 ie. no prerequisite
        queue = deque([i for i in range(numCourses) if indegree[i] == 0])

        # counter for counting completed course
        completedCourse = 0

        while queue:

            # Take the course from queue
            course = queue.popleft()
            completedCourse += 1

            # decerement the value of indegree of the successor of the course
            for successor in graph[course]:
                indegree[successor] -= 1

                # if the indegree value of successor course is 0 then we can append the value to an array
                if indegree[successor] == 0:
                    queue.append(successor)
        
        # return true if all the course are completed else return false
        return completedCourse == numCourses


        